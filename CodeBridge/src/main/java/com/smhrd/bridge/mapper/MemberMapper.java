package com.smhrd.bridge.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Member;

@Mapper
public interface MemberMapper {

	@Insert("insert into Member values(#{user_id}, #{user_pw}, #{user_name}, "
			+ "#{user_nick}, #{user_pic}, #{user_phone}, #{user_type}, sysdate())")
	public int memberJoin(Member member);

	@Select("select * from Member where user_id = #{id}")
	public String idCheck(String id);

	@Select("select * from Member where user_id = #{user_id} and user_pw = #{user_pw}")
	public String memberLogin(Map<String, Object> map);
	
	
	
}
