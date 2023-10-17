package com.smhrd.bridge.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Member;
import com.smhrd.bridge.service.MemberService;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("MemberJoin.do")
	public String MemberJoin(@RequestBody Member member) {
		System.out.println("MemberJoin진입완료");
		System.out.println("멤버 확인" + member);

		int row = memberService.MemberJoin(member);

		String message = null;
		if (row > 0) {
			message = "success";
		} else {
			message = "false";
		}

		return message;
	}

	@RequestMapping("MemberLogin.do")
	public void MemberLogin(Member member) {
		memberService.MemberLogin(member);
		System.out.println("로그인성공");

	}

	@RequestMapping("IdCheck.do")
	public String IdCheck(@RequestBody Map<String, Object> map) {
		System.out.println("id확인" + map.get("user_id"));
		String id = (String) map.get("user_id");
		String result = memberService.IdCheck(id);
		String massage = null;

		if (result == null) {
			massage = "O";
		} else if (result != null) {
			massage = "X";
		}

		return massage;
	}

}
