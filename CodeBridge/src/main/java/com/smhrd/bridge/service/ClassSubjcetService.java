package com.smhrd.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.mapper.ClassSubjcetMapper;

@Service
public class ClassSubjcetService {

	@Autowired
	private ClassSubjcetMapper classSubjcetMapper;

	public int insertSub(int class_num, String sub_num_list) {
		String[] sub_num_array = sub_num_list.split(",");
		int row = 0;
		for (String sub_num : sub_num_array) {
			row = classSubjcetMapper.insertSub(class_num, sub_num);
		}
		return row;
	}

}
