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

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Class")
public class ClassController {

	@Autowired
	private ClassService classService;

	// 반 작성
	@RequestMapping("/write")
	public String classWrite(@RequestBody Classroom classroom) {
		int row = classService.classWrite(classroom);
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
