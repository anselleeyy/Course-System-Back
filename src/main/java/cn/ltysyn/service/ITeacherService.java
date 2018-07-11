package cn.ltysyn.service;

import java.util.List;

import cn.ltysyn.bean.Teacher;

public interface ITeacherService {

	public String checkPassword(int teaId);
	
	public boolean addNewTeacher(Teacher teacher, int departmentId);
	
	public List<Teacher> selectAllTeacher();
	
	public boolean updatePwd(String password, int teaId);
	
	public boolean deleteTeacher(int teaId);
	
	public Teacher selectTeacherById(int teaId);
	
	public boolean updateTeacher(int teaId, int depId, String teaName);
}
