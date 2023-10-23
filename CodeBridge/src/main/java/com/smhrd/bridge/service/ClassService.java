package com.smhrd.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Classroom;
import com.smhrd.bridge.mapper.ClassMapper;

@Service
public class ClassService {

	@Autowired
	private ClassMapper classMapper;

	public int classWrite(Classroom classroom) {
		System.out.println("강의정보" + classroom);
		int row = classMapper.classWrite(classroom);
		return row;
	}

	public List<Classroom> findByNum(int class_num) {
		List<Classroom> class_item = classMapper.findByNum(class_num);
		return class_item;
	}

}
