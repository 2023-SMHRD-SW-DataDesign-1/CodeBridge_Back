package com.smhrd.bridge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.service.SubService;
import com.smhrd.bridge.service.SubjectTestService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("*")
@RequestMapping("/subjecTtest")
public class SubjectTestController {

	@Autowired
	private SubjectTestService subjectTestService;
	@Autowired
	private SubService subService;

	@RequestMapping("/submit")
	public String subTest(@RequestBody Map<String, Object> req) {
		int sub_num = (Integer) req.get("sub_num");
		List<Integer> test_num = (List<Integer>) req.get("test_num");


		int row = subjectTestService.subTest(sub_num, test_num);
		subService.updateTested(sub_num);

		return (row > 0) ? "success" : "fail";

	}

}
