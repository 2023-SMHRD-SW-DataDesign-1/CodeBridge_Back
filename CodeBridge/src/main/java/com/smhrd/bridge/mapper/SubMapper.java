package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.bridge.entity.Subject;

@Mapper
public interface SubMapper {

	@Insert("insert into Subject values(default, #{user_id}, #{sub_lang}, #{sub_title}, 0, 0, sysdate())")
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

}
