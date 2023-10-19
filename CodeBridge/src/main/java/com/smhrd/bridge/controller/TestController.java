package com.smhrd.bridge.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Map<String, Object>> testMark(@RequestBody Map<String, Object> map) {
		System.out.println("json 확인" + map);
		String test_num = (String) map.get("test_num");

		System.out.println("번호 확" + test_num);

		String user_id = (String) map.get("user_id");
		List<Map<String, String>> testItem = testService.getTestInfo(test_num);

		List<Map<String, String>> sub_code = codeService.getSubCode(user_id, test_num);

		List<Map<String, Object>> combinedDataList = new ArrayList<>();

		for (int i = 0; i < testItem.size(); i++) {
			Map<String, Object> combinedData = new HashMap<>();
			combinedData.putAll(testItem.get(i)); // testItem의 i번째 아이템을 추가

			// sub_code의 내용을 combinedData에 추가
			combinedData.put("sub_code", sub_code.get(i).get("sub_code"));

			combinedDataList.add(combinedData);
		}

		System.out.println("결합데이터 확인" + combinedDataList);

		return combinedDataList;

	}

}
