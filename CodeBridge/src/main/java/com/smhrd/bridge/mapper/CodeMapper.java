package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Code;

@Mapper
public interface CodeMapper {

	@Insert("insert into CodeSave values(#{test_num}, #{user_id}, #{sub_code}, sysdate())")
	public int codeSubmit(Code code);

	@Select("select test_num, sub_code from CodeSave where user_id = #{user_id} and test_num in (${test_num})")
	public List<Map<String, String>> getSubCode(String user_id, String test_num);

	@Insert({ "<script>", "insert into SubjectStudent values",
			"<foreach item='item' index='index' collection='sub_num' separator=','>", "(#{item}, #{user_id}, default)",
			"</foreach>", "</script>" })
	public void updateSubed(@Param("sub_num") List<Integer> sub_num, @Param("user_id") String user_id);

}
