package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Subject;

@Mapper
public interface SubMapper {

	@Insert("insert into Subject values(default, #{user_id}, #{sub_lang}, #{sub_title}, 0, sysdate())")
	public int subInsert(Map<String, Object> map);

	@Select("SELECT s.sub_num, m.user_name, s.sub_lang, s.sub_title, s.used\r\n"
			+ "FROM Subject s\r\n"
			+ "JOIN Member m ON s.user_id = m.user_id\r\n"
			+ "WHERE s.used = 0;")
	public List<Subject> subSearch();

	@Select("SELECT s.sub_num, m.user_name, s.sub_lang, s.sub_title, s.used\r\n"
			+ "FROM Subject s JOIN Member m \r\n"
			+ "ON s.user_id = m.user_id\r\n"
			+ "WHERE s.used = 0\r\n"
			+ "AND s.sub_lang = #{sub_lang}")
	public List<Subject> findByName(String sub_lang);

}
