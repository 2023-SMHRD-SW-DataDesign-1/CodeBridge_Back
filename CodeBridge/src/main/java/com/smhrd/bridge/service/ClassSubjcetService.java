package com.smhrd.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.mapper.ClassSubjcetMapper;

@Service
public class ClassSubjcetService {

	@Autowired
	private ClassSubjcetMapper classSubjcetMapper;

	public void insertSub(int class_num, String sub_num_list) {
		String[] sub_num_array = sub_num_list.split(",");
		for (String sub_num : sub_num_array) {
			System.out.println("서비스에서 sub번호 확인" + sub_num);
			classSubjcetMapper.insertSub(class_num, sub_num);
		}

	}

}
