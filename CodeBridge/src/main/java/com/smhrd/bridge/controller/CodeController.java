package com.smhrd.bridge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Code;
import com.smhrd.bridge.repository.CodeSaveRepository;
import com.smhrd.bridge.service.CodeService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/code")
public class CodeController {

	@Autowired
	private CodeService codeService;
	@Autowired
	private CodeSaveRepository codeSaveRepository;

	// 학생의 코드 제출
	@RequestMapping("submit")
	public String codeSubmit(@RequestBody Code code) {

		int row = codeService.codeSubmit(code);

		String message = null;
		if (row > 0) {
			message = "Success";
		}

		return message;
	}

	// 학생 코드 제출 vscscode 버전
	@PostMapping("/sub-code-list")
	public ResponseEntity<String> subCodeList(@RequestBody Map<String, Object> req) {
		List<Integer> testNums = (List<Integer>) req.get("test_num");
		String userId = (String) req.get("user_id");
		List<String> subCodes = (List<String>) req.get("sub_code");
		List<Code> codeSaveList = new ArrayList<>();
		int sub_num = Integer.parseInt((String) req.get("sub_num"));

		for (int i = 0; i < testNums.size(); i++) {
			Code codeSave = new Code();
			codeSave.setTest_num(testNums.get(i));
			codeSave.setUser_id(userId);
			codeSave.setSub_code(subCodes.get(i));
			codeSave.setRegi_date(new java.sql.Timestamp(System.currentTimeMillis()));
			codeSaveList.add(codeSave);
		}
		codeSaveRepository.saveAll(codeSaveList);
		codeService.updateSubed(sub_num, userId);

		return new ResponseEntity<>("success", HttpStatus.OK);
	}

}
