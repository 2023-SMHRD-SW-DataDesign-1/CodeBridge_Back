package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectTestMapper {

	@Insert("INSERT INTO SubjectTest VALUES (#{sub_num}, #{num})")
	public int subTest(int sub_num, int num);

}
