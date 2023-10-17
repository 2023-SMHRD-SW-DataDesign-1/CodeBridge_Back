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
@RequestMapping("/Member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/join")
	public String memberJoin(@RequestBody Member member) {
		System.out.println("MemberJoin진입완료");
		System.out.println("멤버 확인" + member);

		int row = memberService.memberJoin(member);

		String message = null;
		if (row > 0) {
			message = "success";
		} else {
			message = "false";
		}

		return message;
	}

	@RequestMapping("/login")
	public String memberLogin(@RequestBody Map<String, Object> map) {
		System.out.println("멤버확인" + map);
		String mem = memberService.memberLogin(map);
		String massage = null;
		if(mem==null) {
			massage="N";
		}else {
			massage="Y";
		}
		System.out.println("맞는회원정보"+mem);
		System.out.println(massage);
		
		return massage;

	}

	@RequestMapping("idCheck")
	public String idCheck(@RequestBody Map<String, Object> map) {
		System.out.println("id확인" + map.get("user_id"));
		String id = (String) map.get("user_id");
		String result = memberService.idCheck(id);
		String massage = null;

		if (result == null) {
			massage = "O";
		} else if (result != null) {
			massage = "X";
		}

		return massage;
	}

}
