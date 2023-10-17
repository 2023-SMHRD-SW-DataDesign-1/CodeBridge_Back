package com.smhrd.bridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.classs;
import com.smhrd.bridge.service.ClassService;


@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping("ClassWirte.do")
	public String ClassWrite(@RequestBody classs classs) {
		
		System.out.println("받음?" + classs);
		
		int row = classService.ClassWrite(classs);

		String message = null;
		if (row > 0) {
			message = "success";
		} else {
			message = "false";
		}

		return message;
	}
	
	

}
