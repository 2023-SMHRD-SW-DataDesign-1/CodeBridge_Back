package com.smhrd.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.smhrd.bridge.entity.classs;
import com.smhrd.bridge.mapper.ClassMapper;


@Service
public class ClassService {
	
	
	@Autowired
	private ClassMapper classMapper;
	
	public int ClassWrite(classs classs) {
		System.out.println("강의정보" + classs);
		int row = classMapper.ClassWrite(classs);
		return row;
	}

}
