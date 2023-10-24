package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassSubjcetMapper {

	@Insert("INSERT INTO ClassSubject VALUES (#{class_num}, #{sub_num})")
	int insertSub(int class_num, String sub_num);

}
