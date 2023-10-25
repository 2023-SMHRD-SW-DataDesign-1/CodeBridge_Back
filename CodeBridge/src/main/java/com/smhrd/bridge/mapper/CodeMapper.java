package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Code;

@Mapper
public interface CodeMapper {

	@Insert("insert into CodeSave values(#{test_num}, #{user_id}, #{sub_code}, sysdate())")
	public int codeSubmit(Code code);

	@Select("select test_num, sub_code from CodeSave where user_id = #{user_id} and test_num in (${test_num})")
	public List<Map<String, String>> getSubCode(String user_id, String test_num);

	@Insert("insert into SubjectStudent values(#{sub_num}, #{user_id})")
	public void updateSubed(int sub_num, String user_id);

}
