package com.smhrd.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.mapper.SubjectTestMapper;

@Service
public class SubjectTestService {

	@Autowired
	private SubjectTestMapper subjectTestMapper;

	public int subTest(int sub_num, List<Integer> test_num) {
		int row = 0;
		for (Integer num : test_num) {
			row = subjectTestMapper.subTest(sub_num, num);
		}
		return row;
	}

}
