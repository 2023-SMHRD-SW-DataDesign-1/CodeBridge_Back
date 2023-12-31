package com.smhrd.bridge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.Member;
import com.smhrd.bridge.service.MemberService;
import com.smhrd.bridge.service.UserSha256;

@RestController // 리엑트 서버로 데이터만 응답
@CrossOrigin("*")
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/join")
	public String memberJoin(@RequestBody Member member) {

		String encryPassword = UserSha256.encrypt(member.getUser_pw());
		member.setUser_pw(encryPassword);

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

	// 약력 수정
	@RequestMapping("/hisedit")
	public String hisEdit(@RequestBody Map<String, Object> req) {
		int row = memberService.hisEdit(req);

		return (row > 0 ? "success" : "fail");
	}

	@RequestMapping("/iddelete")
	public int idDelete(@RequestBody Map<String, Object> map) {
		int row = memberService.idDelete(map);

		return row;
	}

	@RequestMapping("/changepic")
	public String changePic(@RequestBody Map<String, Object> map) {
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
		return "Request received!";
	}

	// 부여 안된 ide 가져오기
	@GetMapping("/getIdeUrl")
	public List<String> getIdeUrl() {
		List<String> url = memberService.getIdeUrl();
		return url;
	}

	// ide 주소 부여
	@PostMapping("giveIde")
	public String giveIde(@RequestBody Map<String, Object> req) {
		int row = memberService.giveIde(req);
		memberService.updateUseIde(req);
		return (row > 0 ? "success" : "fail");
	}

}
