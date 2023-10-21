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

import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.entity.TestSubCode;
import com.smhrd.bridge.service.TestService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Test")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/write")
	public int testWrite(@RequestBody Test test) {
		int row = testService.testWrite(test);
		System.out.println("컨트롤러 들어왔나" + test);

		System.out.println("row" + row);
		return row;
	}

	@RequestMapping("/mark")
	public List<TestSubCode> testMark(@RequestBody Map<String, Object> map) {
		System.out.println("json 확인" + map);
		String test_num = (String) map.get("test_num");

		System.out.println("번호 확" + test_num);

		String user_id = (String) map.get("user_id");
		List<TestSubCode> testItem = testService.getTestInfo(test_num, user_id);

		System.out.println("testitem 확인" + testItem);

		return testItem;
	}

	@RequestMapping("/detail")
	public ArrayList<Test> getTestList(@RequestParam int sub_num) {
		System.out.println("테스트리스트컨트롤");
		ArrayList<Test> testinfo = testService.getTestList(sub_num);
		System.out.println("배열 testinfo확인" + testinfo);
		return testinfo;
	}

}
