package com.smhrd.bridge.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Test;

@Mapper
public interface TestMapper {

	@Insert("insert into TestBank values(default, #{test_title}, #{test_level}, "
			+ "#{test_lang}, #{test_contents}, #{test_condition}, sysdate())")
	public int testWrite(Test test);

	@Select("select test_contents, test_condition from TestBank where test_num = #{test_num}")
	public Map<String, String> getTestInfo(int test_num);

}
