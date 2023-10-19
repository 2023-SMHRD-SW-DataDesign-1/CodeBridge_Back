package com.smhrd.bridge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.mapper.TestMapper;

@Service
public class TestService {

	@Autowired
	private TestMapper testmapper;

	public int testWrite(Test test) {
		int row = testmapper.testWrite(test);

		return row;
	}

	public List<Map<String, String>> getTestInfo(String test_num) {
		
		System.out.println("서비스에서 번호 확인" + test_num);
		
		List<Map<String, String>> testItem = testmapper.getTestInfo(test_num);
		
		

		return testItem;
	}

}
