package com.smhrd.bridge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.entity.TestSubCode;
import com.smhrd.bridge.service.TestService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("*")
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	// 테스트 작성
	@RequestMapping("/write")
	public void testWrite(@RequestBody Map<String, Object> req) {

		String test_title = (String) req.get("test_title");
		int test_level = (int) req.get("test_level");
		String test_lang = (String) req.get("test_lang");
		String test_description = (String) req.get("test_description");
		String test_input = (String) req.get("test_input");
		List<Map<String, Object>> test_condition_list = (List<Map<String, Object>>) req.get("test_condition");

		StringBuilder resultString = new StringBuilder();

		for (Map<String, Object> item : test_condition_list) {
			String id = (String) item.get("id");
			String value = (String) item.get("value");
			resultString.append(id).append(" : ").append(value).append("brbr");
		}
		// 마지막 쉼표와 공백 제거
		String test_condition = resultString.substring(0, resultString.length() - 4);


		Test test = new Test();
		test.setTest_title(test_title);
		test.setTest_level(test_level);
		test.setTest_lang(test_lang);
		test.setTest_description(test_description);
		test.setTest_input(test_input);
		test.setTest_condition(test_condition);

//		int row = testService.testWrite(test);

//		return row;
	}

	// 채점하기 위해 테스트 정보긁어오기
	@RequestMapping("/mark")
	public List<TestSubCode> testMark(@RequestBody Map<String, Object> map) {
		String test_num = (String) map.get("test_num");
		String user_id = (String) map.get("user_id");
		List<TestSubCode> testItem = testService.getTestInfo(test_num, user_id);


		return testItem;
	}

	// sub_num으로 해당 과목 테스트정보 긁어오기
	@RequestMapping("/detail")
	public ArrayList<Test> getTestList(@RequestParam int sub_num) {
		ArrayList<Test> testinfo = testService.getTestList(sub_num);
		return testinfo;
	}

	// 모든 테스트정보 긁어오기
	@RequestMapping("/getall")
	public List<Test> getAllTest() {
		List<Test> test_list = testService.getAllTest();
		return test_list;
	}

}
