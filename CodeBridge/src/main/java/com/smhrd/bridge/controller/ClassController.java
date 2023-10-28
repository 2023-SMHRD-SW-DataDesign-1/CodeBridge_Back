package com.smhrd.bridge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.bridge.entity.Classroom;
import com.smhrd.bridge.service.ClassService;
import com.smhrd.bridge.service.ClassSubjcetService;
import com.smhrd.bridge.service.SubService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService classService;
	@Autowired
	private SubService subService;
	@Autowired
	private ClassSubjcetService classSubjcetService;

	// 반 작성
	@RequestMapping("/write")
	public String classWrite(@RequestBody Map<String, Object> req) {

		System.out.println("req확인" + req);

		String curriculumString = (String) req.get("curriculum");
		List<List<Object>> curriculumList = new ArrayList<>();

		String[] sections = curriculumString.split(",,");
		for (String section : sections) {
			String[] parts = section.split("::");
			String week = parts[0].trim();
			String details = parts[1].trim();

			String[] detailParts = details.split(",");
			int subjectNumber = Integer.parseInt(detailParts[0].trim().split(":")[1].trim());
			String language = detailParts[1].trim().split(":")[1].trim();
			String instructor = detailParts[2].trim().split(":")[1].trim();
			String lectureTitle = detailParts[3].trim().split(":")[1].trim();

			List<Object> curriculumItem = new ArrayList<>();
			curriculumItem.add(week);
			curriculumItem.add(subjectNumber);
			curriculumItem.add(lectureTitle);

			curriculumList.add(curriculumItem);
		}

		ObjectMapper mapper = new ObjectMapper();
		String curri = null;
		try {
			curri = mapper.writeValueAsString(curriculumList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("curriculumList 값 확인" + curriculumList);

		Classroom classroom = new Classroom();

		// Map에서 필요한 데이터 추출
		classroom.setUser_id((String) req.get("user_id"));
		classroom.setClass_title((String) req.get("class_title"));
		classroom.setImg_url((String) req.get("img_url"));
		classroom.setClass_content((String) req.get("class_content"));
		classroom.setClass_target((String) req.get("class_target"));
//		classroom.setCurriculum((String) req.get("curriculum"));
		classroom.setCurriculum(curri);
		classroom.setClass_startdate((String) req.get("class_startdate"));
		classroom.setClass_enddate((String) req.get("class_enddate"));

		int class_num = classService.classWrite(classroom);

		String sub_num_list = (String) req.get("sub_num");
		subService.updateUsed(sub_num_list);
		int row = classSubjcetService.insertSub(class_num, sub_num_list);

		return (row > 0) ? "success" : "false";
	}

	// 반 번호로 반 정보 조회
	@GetMapping("/findnum")
	public List<Classroom> findByNum(@RequestParam int class_num) {

		List<Classroom> class_item = classService.findByNum(class_num);
		return class_item;

	}

	// 아이디로 속한 반 있는지 검사
	@GetMapping("/findbyid")
	public boolean findById(@RequestParam String user_id) {
		Integer row = classService.findById(user_id);
		return (row != null ? true : false);
	}

	// 수정필요
	@GetMapping("/get-class-list")
	public List<Classroom> getClassList() {
		List<Classroom> class_list = classService.getClassList();
		return class_list;
	}

	// 등록 메서드
	@PostMapping("/regist")
	public String resgistClass(@RequestBody Map<String, Object> req) {
		int row = classService.registClass(req);
		return (row > 0 ? "success" : "fail");
	}

	// 반 등록 했는지 검사
	@GetMapping("/registed")
	public String isRegisted(@RequestParam("class_num") int class_num, @RequestParam("user_id") String user_id) {
		Integer row = classService.isRegisted(class_num, user_id);
		return (row == null ? "none" : "registed");
	}

}
