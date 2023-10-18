package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bridge.entity.Member;
import com.smhrd.bridge.entity.Test;

@Mapper
public interface TestMapper {
	
	@Insert("insert into TestBank values(default, #{test_title}, #{test_level}, "
			+ "#{test_lang}, #{test_contents}, #{test_condition}, sysdate())")
	public int TestWrite(Test test);



}
