package com.smhrd.bridge.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MarkMapper {

	@Insert("insert into MarkResult values(#{sub_num}, #{test_num}, #{user_id}, #{mark_result}, #{mark_score}, default)")
	int uploadMark(Map<String, Object> req);

	@Update("update SubjectStudent set tested = 1 where sub_num = #{sub_num} and user_id = #{user_id}")
	int testSubmit(Map<String, Object> req);

}
