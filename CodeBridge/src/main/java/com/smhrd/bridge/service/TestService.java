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

	public Map<String, String> getTestInfo(int test_num) {
		Map<String, String> testItem = testmapper.getTestInfo(test_num);

		return testItem;
	}

}
