package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;

import com.smhrd.bridge.entity.Member;

public interface MemberMapper {

	@Insert("insert into Member values(#{user_id}, #{user_pw}, #{user_name}, "
			+ "#{user_nick}, #{user_pic}, #{user_phone}, #{user_type}, sysdate)")
	public int MemberJoin(Member member);

	public String IdCheck(String id);
	
}
