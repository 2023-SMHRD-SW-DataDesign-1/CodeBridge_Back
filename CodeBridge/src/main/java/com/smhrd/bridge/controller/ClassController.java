package com.smhrd.bridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Classroom;
import com.smhrd.bridge.service.ClassService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Class")
public class ClassController {

	@Autowired
	private ClassService classService;

	@RequestMapping("/write")
	public String classWrite(@RequestBody Classroom classroom) {

		System.out.println("받음?" + classroom);

		int row = classService.classWrite(classroom);

		String message = null;
		if (row > 0) {
			message = "success";
		} else {
			message = "false";
		}

		return message;
	}

}
