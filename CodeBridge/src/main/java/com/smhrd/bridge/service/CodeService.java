package com.smhrd.bridge.service;

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

	public String getSubCode(String user_id, int test_num) {
		String sub_code = codeMapper.getSubCode(user_id, test_num);
		return sub_code;
	}

}
