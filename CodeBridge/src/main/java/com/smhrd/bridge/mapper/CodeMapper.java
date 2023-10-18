package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Code;

@Mapper
public interface CodeMapper {

	@Insert("insert into CodeSave values(#{test_num}, #{user_id}, #{sub_code}, sysdate())")
	public int codeSubmit(Code code);

	@Select("select sub_code from CodeSave where user_id = #{user_id} and test_num = #{test_num}")
	public String getSubCode(String user_id, int test_num);

}
