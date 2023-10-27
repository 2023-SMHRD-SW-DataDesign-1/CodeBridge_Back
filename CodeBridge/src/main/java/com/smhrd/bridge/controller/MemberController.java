package com.smhrd.bridge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Member;
import com.smhrd.bridge.service.MemberService;
import com.smhrd.bridge.service.UserSha256;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("http://localhost:3000")
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/join")
	public String memberJoin(@RequestBody Member member) {

		String encryPassword = UserSha256.encrypt(member.getUser_pw());
		member.setUser_pw(encryPassword);
		System.out.println("암호화한패스워드:" + member.getUser_pw());

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
	public String memberLogin(@RequestBody Member member) {
		String user_pw = member.getUser_pw();
		member.setUser_pw(UserSha256.encrypt(user_pw));
		// 암호화 확인
		System.out.println("user_pw : " + member.getUser_pw());

		String mem = memberService.memberLogin(member);
		String massage = null;
		if (mem == null) {
			massage = "N";
		} else {
			massage = "Y";
		}

		return massage;

	}

	@RequestMapping("idCheck")
	public String idCheck(@RequestBody Map<String, Object> map) {
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

	// 아이디로 정보찾기 학생용
	@RequestMapping("/memcheck")
	public List<Member> memberCheck(@RequestBody Map<String, Object> id) {
		List<Member> mem = memberService.memberCheck(id);
		return mem;
	}

	// 아이디로 정보찾기 선생용
	@GetMapping("/memberInfoTeacher")
	public List<Member> memberInfoTeacher(@RequestParam String user_id) {
		List<Member> mem = memberService.memberInfoTeacher(user_id);
		return mem;
	}

	@RequestMapping("/nameedit")
	public int nameEdit(@RequestBody Map<String, Object> map) {
		int row = memberService.nameEdit(map);

		return row;
	}

	@RequestMapping("/nickedit")
	public int nickEdit(@RequestBody Map<String, Object> map) {
		int row = memberService.nickEdit(map);
		return row;
	}

	@RequestMapping("/phoneedit")
	public int phoneEdit(@RequestBody Map<String, Object> map) {
		int row = memberService.phoneEdit(map);

		return row;
	}

	@RequestMapping("/passwordedit")
	public int passwordEdit(@RequestBody Map<String, Object> map) {
		int row = memberService.passwordEdit(map);

		return row;
	}

	@RequestMapping("/iddelete")
	public int idDelete(@RequestBody Map<String, Object> map) {
		int row = memberService.idDelete(map);

		return row;
	}

	@RequestMapping("/changepic")
	public String changePic(@RequestBody Map<String, Object> map) {
		System.out.println("받은 값 확인" + map);
		String user_id = (String) map.get("user_id");
		String user_pic = (String) map.get("user_pic");
		int row = memberService.changePic(user_id, user_pic);

		String result = null;
		if (row > 0) {
			result = "success";
		} else {
			result = "fail";
		}

		return result;
	}
	
	@RequestMapping("/your-endpoint")
	public String handleRequest() {
		System.out.println("요청옴");
		return "Request received!";
	}

}
