package com.smhrd.bridge.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.service.TestService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Test")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("write")
	public int testWrite(@RequestBody Test test) {
		int row = testService.testWrite(test);
		System.out.println("컨트롤러 들어왔나" + test);

		System.out.println("row" + row);
		return row;
	}

}
