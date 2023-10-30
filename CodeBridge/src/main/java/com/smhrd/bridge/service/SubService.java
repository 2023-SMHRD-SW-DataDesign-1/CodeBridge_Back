package com.smhrd.bridge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Subject;
import com.smhrd.bridge.entity.SubjectStudent;
import com.smhrd.bridge.entity.SubjectTest;
import com.smhrd.bridge.mapper.SubMapper;

@Service
public class SubService {

	@Autowired
	private SubMapper subMapper;

	public int subInsert(Map<String, Object> map) {
		int row = subMapper.subInsert(map);
		return row;
	}

	public List<Subject> subSearch() {
		List<Subject> sub_list = subMapper.subSearch();
		return sub_list;
	}

	public List<Subject> findByName(String sub_lang) {
		List<Subject> sub_list = subMapper.findByName(sub_lang);
		return sub_list;
	}

	public List<Subject> getSubs(int class_num) {
		List<Subject> sub = subMapper.getSubs(class_num);
		return sub;
	}

	public void updateUsed(String sub_num_list) {
		subMapper.updateUsed(sub_num_list);

	}

	public void updateTested(int sub_num) {
		subMapper.updateTested(sub_num);

	}

	public List<SubjectStudent> istested(String sub_num, String user_id) {
		List<SubjectStudent> tested = subMapper.istested(sub_num, user_id);
		return tested;

	}

	public List<Subject> getSubDetailList(String sub_num) {
		List<Subject> sub_list = subMapper.getSubDetailList(sub_num);
		return sub_list;
	}

	public List<Integer> getSubNumList(int class_num) {
		List<Integer> sub_list = subMapper.getSubNumList(class_num);
		return sub_list;
	}

}
