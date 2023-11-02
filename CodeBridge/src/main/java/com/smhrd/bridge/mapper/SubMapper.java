package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.bridge.entity.Subject;
import com.smhrd.bridge.entity.SubjectStudent;
import com.smhrd.bridge.entity.SubjectTest;
import com.smhrd.bridge.entity.TotalScore;

@Mapper
public interface SubMapper {

	@Insert("insert into Subject values(default, #{user_id}, #{sub_lang}, #{sub_title}, #{sub_content}, 0, 0, sysdate())")
	public int subInsert(Map<String, Object> map);

	@Select("SELECT s.sub_num, m.user_name, s.sub_lang, s.sub_title, s.used\r\n" + "FROM Subject s\r\n"
			+ "JOIN Member m ON s.user_id = m.user_id\r\n" + "WHERE s.used = 0;")
	public List<Subject> subSearch();

	@Select("SELECT s.sub_num, m.user_name, s.sub_lang, s.sub_title, s.used\r\n" + "FROM Subject s JOIN Member m \r\n"
			+ "ON s.user_id = m.user_id\r\n" + "WHERE s.used = 0\r\n" + "AND s.sub_lang = #{sub_lang}")
	public List<Subject> findByName(String sub_lang);

	@Select("SELECT Subject.*\r\n" + "FROM ClassSubject\r\n"
			+ "INNER JOIN Subject ON ClassSubject.sub_num = Subject.sub_num\r\n"
			+ "WHERE ClassSubject.class_num = #{class_num};")
	public List<Subject> getSubs(int class_num);

	@Update("update Subject set used = 1 where sub_num in (${sub_num_list})")
	public void updateUsed(String sub_num_list);

	@Update("update Subject set tested = 1 where sub_num = #{sub_num}")
	public void updateTested(int sub_num);

	@Select("select * from SubjectStudent where sub_num in (${sub_num}) and user_id = #{user_id}")
	public List<SubjectStudent> istested(String sub_num, String user_id);

	@Select("select * from Subject where sub_num in (${sub_num})")
	public List<Subject> getSubDetailList(String sub_num);

	@Select("select sub_num from ClassSubject where class_num = #{class_num}")
	public List<Integer> getSubNumList(int class_num);

	@Select("SELECT sub_num, \r\n"
			+ "       SUM(test_level) * 10 as score\r\n"
			+ "FROM   SubjectTest \r\n"
			+ "JOIN   TestBank \r\n"
			+ "ON     SubjectTest.test_num = TestBank.test_num \r\n"
			+ "WHERE  sub_num IN (${sub_num}) \r\n"
			+ "GROUP BY sub_num;")
	public List<TotalScore> getTotalScore(String sub_num);

}
