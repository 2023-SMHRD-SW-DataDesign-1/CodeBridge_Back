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
		int row = memberMapper.MemberJoin(member);
	return row;
	}
	
	public String IdCheck(String id) {
		String result = memberMapper.IdCheck(id);

		System.out.println("result : " + result);
		// 데이터 가공
		if (result == null)
			result = "사용 가능한 아이디입니다.";
		else
			result = "중복된 아이디입니다";

		return result;
	}

	public void MemberLogin(Member member) {
		
		
	}
}
