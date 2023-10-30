package com.smhrd.bridge.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.service.MarkService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/mark")
public class MarkController {

	@Autowired
	private MarkService markService;

	@PostMapping("result")
	public String uploadMark(@RequestBody Map<String, Object> req) {
		System.out.println("요청 확인" + req);
		int row = markService.uploadMark(req);
		return (row > 0 ? "Success" : "fail");
	}

}
