package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.bridge.entity.MarkResult;
import com.smhrd.bridge.entity.MarkResultStu;

@Mapper
public interface MarkMapper {

	@Insert("insert into MarkResult values(#{sub_num}, #{test_num}, #{user_id}, #{sub_code}, #{mark_result}, #{mark_score}, default, default)")
	int uploadMark(Map<String, Object> req);

	@Update("update SubjectStudent set tested = 1 where sub_num = #{sub_num} and user_id = #{user_id}")
	int testSubmit(Map<String, Object> req);

	@Select("select sub_num from ClassSubject where class_num = #{class_num}")
	List<Integer> getMarkScore(Map<String, Object> req);

	@Select("SELECT m.sub_num, SUM(m.mark_score) AS mark_score, SUM(m.objection) AS objection, s.sub_title\r\n"
			+ "FROM MarkResult m\r\n" + "JOIN Subject s ON m.sub_num = s.sub_num\r\n"
			+ "WHERE m.sub_num IN (${sub_num}) AND m.user_id = #{user_id}\r\n" + "GROUP BY m.sub_num, s.sub_title;\r\n"
			+ "")
	List<MarkResult> getScore(String sub_num, String user_id);

	@Select("SELECT MR.sub_num, MR.test_num, MR.user_id, MR.sub_code, MR.mark_result, MR.mark_score, MR.objection, TB.test_description\r\n"
			+ "FROM MarkResult MR\r\n" + "JOIN TestBank TB ON MR.test_num = TB.test_num\r\n"
			+ "WHERE MR.sub_num = #{sub_num} AND MR.user_id = #{user_id};\r\n" + "")
	List<MarkResultStu> getDetailMark(Map<String, Object> req);

	@Update("update MarkResult set objection = 1 where sub_num = #{sub_num} and test_num = #{test_num} and user_id = #{user_id}")
	int markObjection(Map<String, Object> req);

}
