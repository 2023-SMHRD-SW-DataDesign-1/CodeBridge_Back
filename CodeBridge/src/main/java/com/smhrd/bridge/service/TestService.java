package com.smhrd.bridge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.entity.TestSubCode;
import com.smhrd.bridge.mapper.TestMapper;

@Service
public class TestService {

	@Autowired
	private TestMapper testmapper;

	public int testWrite(Test test) {
		int row = testmapper.testWrite(test);

		return row;
	}

	public List<TestSubCode> getTestInfo(String test_num, String user_id) {		
		List<TestSubCode> testItem = testmapper.getTestInfo(test_num, user_id);
		return testItem;
	}

	public ArrayList<Test> getTestList() {
		ArrayList<Test> testinfo = testmapper.getTestList();
		return testinfo;
	}

}
