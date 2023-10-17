package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bridge.entity.Code;

@Mapper
public interface CodeMapper {

	@Insert("insert into CodeSave values(#{test_num}, #{user_id}, #{sub_code}, sysdate())")
	public int codeSubmit(Code code);

}
