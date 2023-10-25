package com.smhrd.bridge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Code;
import com.smhrd.bridge.mapper.CodeMapper;

@Service
public class CodeService {

	@Autowired
	private CodeMapper codeMapper;

	public int codeSubmit(Code code) {
		int row = codeMapper.codeSubmit(code);
		return row;
	}

	public List<Map<String, String>> getSubCode(String user_id, String test_num) {
		List<Map<String, String>> sub_code = codeMapper.getSubCode(user_id, test_num);
		return sub_code;
	}

	public void updateSubed(int sub_num, String user_id) {
		codeMapper.updateSubed(sub_num, user_id);
	}

}
