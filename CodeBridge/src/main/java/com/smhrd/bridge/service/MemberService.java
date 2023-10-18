package com.smhrd.bridge.service;

import java.util.ArrayList;
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
		System.out.println("멤버 다시확인" + member);
		int row = memberMapper.memberJoin(member);
		return row;
	}

	public String idCheck(String id) {
		String result = memberMapper.idCheck(id);
		System.out.println("result"+result);
		
		// 데이터 가공
		return result;
		
	}

	public String memberLogin(Map<String, Object> map) {
		String mem = memberMapper.memberLogin(map);
		return mem;
	}

	public ArrayList<Member> memberCheck(Map<String, Object> id) {
		ArrayList<Member> mem = memberMapper.memberCheck(id);
		return mem;
	}
}
