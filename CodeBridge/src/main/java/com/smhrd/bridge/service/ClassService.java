package com.smhrd.bridge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.ClassMember;
import com.smhrd.bridge.entity.Classroom;
import com.smhrd.bridge.entity.Member;
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

	public List<Classroom> getClassList() {
		List<Classroom> class_list = classMapper.getClassList();
		return class_list;
	}

	public int registClass(Map<String, Object> req) {
		int row = classMapper.registClass(req);
		return row;
	}

	public Integer isRegisted(int class_num, String user_id) {
		Integer row = classMapper.isRegisted(class_num, user_id);
		return row;
	}

	public void insertClassTeacher(int class_num, String user_id, int isteacher) {
		classMapper.insertClassTeacher(class_num, user_id, isteacher);
	}

	public List<ClassMember> getStuList(int class_num) {
		List<ClassMember> stu_list = classMapper.getStuList(class_num);
		return stu_list;
	}

	public int acceptStu(String user_id) {
		int row = classMapper.acceptStu(user_id);

		return row;
	}

	public List<Member> getClassStuList(int class_num) {
		List<Member> mem_list = classMapper.getClassStuList(class_num);
		return mem_list;
	}

}
