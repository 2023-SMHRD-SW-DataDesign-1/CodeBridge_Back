package com.smhrd.bridge.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Test;
import com.smhrd.bridge.entity.TestSubCode;

@Mapper
public interface TestMapper {

	@Insert("insert into TestBank values(default, #{test_title}, #{test_level}, "
			+ "#{test_lang}, #{test_contents}, #{test_condition}, sysdate())")
	public int testWrite(Test test);

	@Select("SELECT tb.test_num, tb.test_contents, tb.test_condition, cs.sub_code \r\n"
			+ "FROM TestBank tb\r\n"
			+ "JOIN CodeSave cs ON tb.test_num = cs.test_num\r\n"
			+ "WHERE tb.test_num IN (${test_num}) AND cs.user_id = #{user_id}\r\n"
			+ "")
	public List<TestSubCode> getTestInfo(String test_num, String user_id);

	@Select("select * from TestBank")
	public ArrayList<Test> getTestList(Map<String, Object> test);

}
