package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.bridge.entity.MarkResult;

@Mapper
public interface MarkMapper {

	@Insert("insert into MarkResult values(#{sub_num}, #{test_num}, #{user_id}, #{mark_result}, #{mark_score}, default)")
	int uploadMark(Map<String, Object> req);

	@Update("update SubjectStudent set tested = 1 where sub_num = #{sub_num} and user_id = #{user_id}")
	int testSubmit(Map<String, Object> req);

	@Select("select sub_num from ClassSubject where class_num = #{class_num}")
	List<Integer> getMarkScore(Map<String, Object> req);

	@Select("SELECT m.sub_num, SUM(m.mark_score) AS mark_score, s.sub_title\r\n"
			+ "FROM MarkResult m\r\n"
			+ "JOIN Subject s ON m.sub_num = s.sub_num\r\n"
			+ "WHERE m.sub_num IN (${sub_num}) AND m.user_id = #{user_id}\r\n"
			+ "GROUP BY m.sub_num, s.sub_title;\r\n"
			+ "")
	List<MarkResult> getScore(String sub_num, String user_id);

}
