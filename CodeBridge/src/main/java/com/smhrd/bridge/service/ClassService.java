package com.smhrd.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Classroom;
import com.smhrd.bridge.mapper.ClassMapper;
import com.smhrd.bridge.repository.ClassroomRepository;

@Service
public class ClassService {

	@Autowired
	private ClassMapper classMapper;
	@Autowired
	private ClassroomRepository classroomRepository;

	public int classWrite(Classroom classroom) {

//		int row = classMapper.classWrite(classroom);
//		int classNum = classroom.getClass_num();
		Classroom savedClassroom = classroomRepository.save(classroom);
		return savedClassroom.getClass_num();
	}

	public List<Classroom> findByNum(int class_num) {
		List<Classroom> class_item = classMapper.findByNum(class_num);
		return class_item;
	}

	public Integer findById(String user_id) {
		Integer row = classMapper.findById(user_id);
		return row;
	}

}
