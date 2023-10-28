package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Classroom;

@Mapper
public interface ClassMapper {

	@Insert("insert into Class values(default, #{user_id}, #{class_title}, #{img_url}, #{class_content}, #{class_target}, #{curriculum}, #{class_startdate}, #{class_enddate}, 1, sysdate())")
	@Options(useGeneratedKeys = true, keyProperty = "classNum")
	public int classWrite(Classroom classroom);

	@Select("select * from Class where class_num = #{class_num}")
	public List<Classroom> findByNum(int class_num);

	@Select("select * from ClassMember where user_id = #{user_id}")
	public Integer findById(String user_id);

	@Select("select * from Class")
	public List<Classroom> getClassList();

	@Insert("insert into ClassMember values(#{class_num}, #{user_id}, default)")
	public int registClass(Map<String, Object> req);

	@Select("select * from ClassMember where class_num = #{class_num} and user_id = #{user_id}")
	public Integer isRegisted(int class_num, String user_id);



}
