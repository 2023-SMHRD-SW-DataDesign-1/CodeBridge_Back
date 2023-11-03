package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.bridge.entity.ClassMember;
import com.smhrd.bridge.entity.Classroom;
import com.smhrd.bridge.entity.Member;

@Mapper
public interface ClassMapper {

	@Insert("insert into Class values(default, #{user_id}, #{class_title}, #{img_url}, #{class_content}, #{class_target}, #{curriculum}, #{class_startdate}, #{class_enddate}, 1, sysdate())")
	@Options(useGeneratedKeys = true, keyProperty = "classNum")
	public int classWrite(Classroom classroom);

	@Select("select * from Class where class_num = #{class_num}")
	public List<Classroom> findByNum(int class_num);

	@Select("select class_num from ClassMember where user_id = #{user_id} and approved = 1")
	public Integer findById(String user_id);

	@Select("select * from Class")
	public List<Classroom> getClassList();

	@Insert("insert into ClassMember values(#{class_num}, #{user_id}, #{user_name}, default, default)")
	public int registClass(Map<String, Object> req);

	@Select("select * from ClassMember where class_num = #{class_num} and user_id = #{user_id}")
	public Integer isRegisted(int class_num, String user_id);

	@Insert("insert into ClassMember values(#{class_num}, #{user_id}, null, default, #{isteacher})")
	public void insertClassTeacher(int class_num, String user_id, int isteacher);

	@Select("select * from ClassMember where class_num = #{class_num}")
	public List<ClassMember> getStuList(int class_num);

	@Update("update ClassMember set approved = 1 where user_id = #{user_id}")
	public int acceptStu(String user_id);

	@Select("SELECT Member.*\r\n"
			+ "FROM Member\r\n"
			+ "JOIN ClassMember ON Member.user_id = ClassMember.user_id\r\n"
			+ "WHERE ClassMember.class_num = #{class_num} AND ClassMember.approved = 1;\r\n"
			+ "")
	public List<Member> getClassStuList(int class_num);

}
