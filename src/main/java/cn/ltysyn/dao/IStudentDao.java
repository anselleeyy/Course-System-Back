package cn.ltysyn.dao;

import java.util.List;

import cn.ltysyn.bean.Student;

public interface IStudentDao {
	
	public Student selectStuById(int stuId);
	
	public void saveNewStudent(Student student);
	
	public List<Student> selectAllStudent();
	
	public void updatePwd(Student student);
	
	public void deleteStudent(Student student);
	
	public void updateStudent(Student student);

}
