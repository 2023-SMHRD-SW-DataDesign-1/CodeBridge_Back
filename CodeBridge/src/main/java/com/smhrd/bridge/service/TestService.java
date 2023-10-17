package com.smhrd.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.mapper.TestMapper;

@Service
public class TestService {
	
	@Autowired
	private TestMapper testmapper;

	public int TestWrite(Test test) {
		int row = testmapper.TestWrite(test);
		
		return row;
	}

	
}
