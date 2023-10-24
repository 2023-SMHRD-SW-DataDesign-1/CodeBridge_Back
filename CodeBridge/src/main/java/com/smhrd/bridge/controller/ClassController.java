package com.smhrd.bridge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Classroom;
import com.smhrd.bridge.service.ClassService;
import com.smhrd.bridge.service.ClassSubjcetService;
import com.smhrd.bridge.service.SubService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Class")
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
		Classroom classroom = new Classroom();

		// Map에서 필요한 데이터 추출
		classroom.setUser_id((String) req.get("user_id"));
		classroom.setClass_title((String) req.get("class_title"));
		classroom.setClass_content((String) req.get("class_content"));
		classroom.setClass_target((String) req.get("class_target"));
		classroom.setCurriculum((String) req.get("curriculum"));
		classroom.setClass_startdate((String) req.get("class_startdate"));
		classroom.setClass_enddate((String) req.get("class_enddate"));

		int class_num = classService.classWrite(classroom);

		String sub_num_list = (String) req.get("sub_num");
		subService.updateUsed(sub_num_list);
		int row = classSubjcetService.insertSub(class_num, sub_num_list);

		return (row > 0) ? "success" : "false";
	}

	// 반 번호로 반 정보 조회
	@RequestMapping("/findnum")
	public List<Classroom> findByNum(@RequestBody Map<String, Object> req) {
		System.out.println("반번호 확인" + req);
		int class_num = (int) req.get("class_num");
		List<Classroom> class_item = classService.findByNum(class_num);
		System.out.println("class아이텝 확인 " + class_item);

		return class_item;

	}

}
