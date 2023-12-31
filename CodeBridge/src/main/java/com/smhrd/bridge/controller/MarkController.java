package com.smhrd.bridge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.bridge.entity.MarkResult;
import com.smhrd.bridge.entity.MarkResultStu;
import com.smhrd.bridge.service.MarkService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("*")
@RequestMapping("/mark")
public class MarkController {

	@Autowired
	private MarkService markService;

	@PostMapping("result")
	public String uploadMark(@RequestBody Map<String, Object> req) {
		int row = markService.uploadMark(req);
		return (row > 0 ? "Success" : "fail");
	}

	@PostMapping("submit")
	public String testSubmit(@RequestBody Map<String, Object> req) {
		int row = markService.testSubmit(req);
		return (row > 0 ? "success" : "fail");
	}

	// 반번호, 학생 아이디로 해당 학생 성적 조회
	@RequestMapping("markresult")
	public List<MarkResult> getMarkScore(@RequestBody Map<String, Object> req) {
		List<Integer> sub_list = markService.getMarkScore(req);
		String sub_num = sub_list.toString().substring(1, sub_list.toString().length() - 1);
		String user_id = (String) req.get("user_id");
		List<MarkResult> score_list = markService.getScore(sub_num, user_id);
		return score_list;
	}

	// 학생 본인 시험결과 확인용
	@PostMapping("detail-mark-result")
	public List<MarkResultStu> getDetailMark(@RequestBody Map<String, Object> req) {
		List<MarkResultStu> list = markService.getDetailMark(req);
		return list;
	}

	// 학생 이의제기
	@PostMapping("mark-objection")
	public String markObjection(@RequestBody Map<String, Object> req) {
		System.out.println("req 확인" + req);
		int row = markService.markObjection(req);
		return (row > 0 ? "success" : "fail");
	}

}
