package com.smhrd.bridge.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	@Select("select * from Member where user_id = #{user_id}")
	public ArrayList<Member> memberCheck(Map<String, Object> id);

	@Update("update Member SET user_name = #{user_name} where user_id = #{user_id}")
	public int nameEdit(Map<String, Object> map);

	@Update("update Member SET user_nick = #{user_nick} where user_id = #{user_id}")
	public int nickEdit(Map<String, Object> map);

	@Update("update Member SET user_phone = #{user_phone} where user_id = #{user_id}")
	public int phoneEdit(Map<String, Object> map);

	@Update("update Member SET user_pw = #{user_pw} where user_id = #{user_id}")
	public int passwordEdit(Map<String, Object> map);

	@Delete("delete FROM Member where user_id = #{user_id}")
	public int idDelete(Map<String, Object> map);
	
	
	
	
	
}
