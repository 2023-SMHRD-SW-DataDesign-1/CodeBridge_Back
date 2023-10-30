package com.smhrd.bridge.controller;

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

import com.smhrd.bridge.entity.Subject;
import com.smhrd.bridge.entity.SubjectStudent;
import com.smhrd.bridge.service.SubService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/sub")
public class SubController {

	@Autowired
	private SubService subservice;

	// 과목 작성
	@RequestMapping("/write")
	public String subInsert(@RequestBody Map<String, Object> map) {
		int row = subservice.subInsert(map);
		return (row > 0) ? "success" : "false";
	}

	// 모든 과목 찾기
	@RequestMapping("/find")
	public List<Subject> subSearch() {
		List<Subject> sub_list = subservice.subSearch();
		return sub_list;
	}

	// 반 넘버로 과목 찾기
	@RequestMapping("/getsub")
	public List<Subject> getSubs(@RequestParam int class_num) {
		List<Subject> sub = subservice.getSubs(class_num);
		return sub;
	}

	// 반 넘버로 과목 번호만 찾기
	@GetMapping("/get-sub-num")
	public List<Integer> getSubNumList(@RequestParam int class_num) {
		List<Integer> sub_list = subservice.getSubNumList(class_num);
		return sub_list;
	}

	// 과목 이름으로 반 검색
	@RequestMapping("/findbyname")
	public List<Subject> findByName(@RequestBody Map<String, String> map) {
		String sub_lang = (String) map.get("sub_lang");
		List<Subject> sub_list = subservice.findByName(sub_lang);

		return sub_list;
	}

	// 학생이 시험을 봤는지 확인하는 엔드포인트
	@PostMapping("/istested")
	public List<SubjectStudent> istested(@RequestBody Map<String, Object> req) {
		System.out.println("req확" + req);
		String sub_num = (String) req.get("sub_num");
		String user_id = (String) req.get("user_id");
		List<SubjectStudent> result = subservice.istested(sub_num, user_id);
		return result;
	}

	@RequestMapping("get-sub-list")
	public List<Subject> getSubDetailList(@RequestBody List<Integer> req) {
		String reqString = req.toString();
		reqString = reqString.substring(1, reqString.length() - 1);
		System.out.println(reqString);
		List<Subject> sub_list = subservice.getSubDetailList(reqString);
		return sub_list;
	}

}
