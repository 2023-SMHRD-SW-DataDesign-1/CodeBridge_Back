package com.smhrd.bridge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.service.CodeService;
import com.smhrd.bridge.service.TestService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Test")
public class TestController {

	@Autowired
	private TestService testService;
	@Autowired
	private CodeService codeService;

	@RequestMapping("write")
	public int testWrite(@RequestBody Test test) {
		int row = testService.testWrite(test);
		System.out.println("컨트롤러 들어왔나" + test);

		System.out.println("row" + row);
		return row;
	}

	@RequestMapping("mark")
	public String testMark(@RequestBody Map<String, Object> map) {
		System.out.println("json 확인" + map);
		int test_num = (Integer) map.get("test_num");
		String user_id = (String) map.get("user_id");
		Map<String, String> testItem = testService.getTestInfo(test_num);
		String sub_code = codeService.getSubCode(user_id, test_num);

		System.out.println("testitem확" + testItem);

		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("test_condition", testItem.get("test_condition"));
		resultMap.put("test_contents", testItem.get("test_contents"));
		resultMap.put("sub_code", sub_code);

		String jsonResult = gson.toJson(resultMap);
		System.out.println("json 형태로 변환된 결과: " + jsonResult);

		return jsonResult;
	}

}
