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

	@Select("SELECT tb.test_num, tb.test_contents, tb.test_condition, cs.sub_code \r\n" + "FROM TestBank tb\r\n"
			+ "JOIN CodeSave cs ON tb.test_num = cs.test_num\r\n"
			+ "WHERE tb.test_num IN (${test_num}) AND cs.user_id = #{user_id}\r\n" + "")
	public List<TestSubCode> getTestInfo(String test_num, String user_id);

	@Select("SELECT TestBank.*\r\n" + "FROM SubjectTest\r\n"
			+ "JOIN TestBank ON SubjectTest.test_num = TestBank.test_num\r\n" + "WHERE SubjectTest.sub_num = #{sub_num};")
	public ArrayList<Test> getTestList(int sub_num);

	@Select("select * from TestBank")
	public List<Test> getAllTest();

}
