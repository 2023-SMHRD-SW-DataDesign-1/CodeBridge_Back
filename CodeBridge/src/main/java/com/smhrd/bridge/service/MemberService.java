package com.smhrd.bridge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Member;
import com.smhrd.bridge.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	public int memberJoin(Member member) {
		int row = memberMapper.memberJoin(member);
		return row;
	}

	public String idCheck(String id) {
		String result = memberMapper.idCheck(id);
		return result;

	}

	public String memberLogin(Member member) {
		String mem = memberMapper.memberLogin(member);
		return mem;
	}

	public List<Member> memberCheck(Map<String, Object> id) {
		List<Member> mem = memberMapper.memberCheck(id);
		return mem;
	}

	public int nameEdit(Map<String, Object> map) {
		int row = memberMapper.nameEdit(map);
		return row;
	}

	public int nickEdit(Map<String, Object> map) {
		int row = memberMapper.nickEdit(map);
		return row;
	}

	public int phoneEdit(Map<String, Object> map) {
		int row = memberMapper.phoneEdit(map);
		return row;
	}

	public int passwordEdit(Map<String, Object> map) {
		int row = memberMapper.passwordEdit(map);
		return row;
	}

	public int idDelete(Map<String, Object> map) {
		int row = memberMapper.idDelete(map);
		return row;
	}

	public int changePic(String user_id, String user_pic) {
		int row = memberMapper.changePic(user_id, user_pic);
		return row;
	}

	public List<Member> memberInfoTeacher(String user_id) {
		List<Member> mem = memberMapper.memberInfoTeacher(user_id);
		return mem;
	}

	public void updateHasClass(String user_id, int class_num) {
		memberMapper.updateHasClass(user_id, class_num);

	}

	public List<String> getIdeUrl() {
		List<String> url = memberMapper.getIdeUrl();
		return url;
	}

	public int giveIde(Map<String, Object> req) {
		int row = memberMapper.giveIde(req);
		return row;
	}

	public void updateUseIde(Map<String, Object> req) {
		memberMapper.updateUseIde(req);

	}

	public int hisEdit(Map<String, Object> req) {
		int row = memberMapper.hisEdit(req);
		return row;
	}

}
