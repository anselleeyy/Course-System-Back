package cn.ltysyn.service;

import java.util.List;

import cn.ltysyn.bean.Student;

public interface IStudentService {
	
	public String checkPassword(int stuId);
	
	public boolean addNewStudent(Student student, int classId);
	
	public List<Student> selectAllStudent();
	
	public boolean updatePwd(String password, int stuId);
	
	public boolean deleteStudent(int stuId);
	
	public Student selectStuById(int stuId);
	
	public boolean updateStudent(int stuId, int classId, String stuName);

}
