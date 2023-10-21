package com.smhrd.bridge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Subject;
import com.smhrd.bridge.service.SubService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/sub")
public class SubController {

	@Autowired
	private SubService subservice;

	@RequestMapping("/write")
	public String subInsert(@RequestBody Map<String, Object> map) {
		System.out.println("json 확인" + map);

		int row = subservice.subInsert(map);

		String result = null;

		if (row > 0) {
			result = "success";
		} else {
			result = "fail";
		}
		return result;
	}

	@RequestMapping("/find")
	public List<Subject> subSearch() {

		List<Subject> sub_list = subservice.subSearch();

		return sub_list;
	}

	@RequestMapping("/findbyname")
	public List<Subject> findByName(@RequestBody Map<String, String> map) {
		System.out.println("들어온 이름" + map.get("sub_lang"));
		String sub_lang = (String) map.get("sub_lang");
		List<Subject> sub_list = subservice.findByName(sub_lang);

		return sub_list;
	}

}
