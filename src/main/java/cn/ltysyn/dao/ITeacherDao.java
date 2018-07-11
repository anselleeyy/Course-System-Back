package cn.ltysyn.dao;

import java.util.List;

import cn.ltysyn.bean.Teacher;

public interface ITeacherDao {
	
	public Teacher selectTeacherById(int teaId);
	
	public void saveNewTeacher(Teacher teacher);
	
	public List<Teacher> selectAllTeacher();
	
	public void updatePwd(Teacher teacher);
	
	public void deleteTeacher(Teacher teacher);
	
	public void updateTeacher(Teacher teacher);

}
