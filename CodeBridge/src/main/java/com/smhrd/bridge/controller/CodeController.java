package com.smhrd.bridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Code;
import com.smhrd.bridge.service.CodeService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Code")
public class CodeController {

	@Autowired
	private CodeService codeService;

	// 학생의 코드 제출
	@RequestMapping("submit")
	public String codeSubmit(@RequestBody Code code) {

		int row = codeService.codeSubmit(code);

		String message = null;
		if (row > 0) {
			message = "Success";
		}

		return message;
	}

}
