package com.smhrd.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.Member;
import com.smhrd.bridge.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	public int MemberJoin(Member member) {
		System.out.println("멤버 다시확인" + member);
		int row = memberMapper.MemberJoin(member);
		return row;
	}

	public String IdCheck(String id) {
		String result = memberMapper.IdCheck(id);
		System.out.println("result"+result);
		
		// 데이터 가공
		return result;
		
	}

	public void MemberLogin(Member member) {
		memberMapper.MemberLogin(member);
	}
}
