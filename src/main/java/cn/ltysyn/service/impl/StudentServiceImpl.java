package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.bean.Clas;
import cn.ltysyn.bean.Student;
import cn.ltysyn.dao.IStudentDao;
import cn.ltysyn.service.IStudentService;
import cn.ltysyn.util.Enctype;

@Service(value = "studentService")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	private Enctype enctype = new Enctype();
	
	@Override
	public String checkPassword(int stuId) {
		// TODO Auto-generated method stub
		String password = studentDao.selectStuById(stuId).getPassword();
		return password;
	}

	@Override
	public boolean addNewStudent(Student student, int classId) {
		// TODO Auto-generated method stub
		Clas clas = new Clas();
		clas.setClassId(classId);
		student.setClas(clas);

		// 密码部分
		String password = "";
		password = enctype.MD5("123456");
		student.setPassword(password);
		
		// 添加
		try {
			studentDao.saveNewStudent(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("teacher 插入失败");
			return false;
		}
	}

	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		List<Student> list = studentDao.selectAllStudent();
		return list;
	}

	// 更新密码
	@Override
	public boolean updatePwd(String password, int stuId) {
		// TODO Auto-generated method stub
		password = enctype.MD5(password);
		Student student = studentDao.selectStuById(stuId);
		student.setPassword(password);
		
		// 开始更新
		try {
			studentDao.updatePwd(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("学生密码更新失败");
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int stuId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student = studentDao.selectStuById(stuId);
		try {
			studentDao.deleteStudent(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("学生删除失败");
			return false;
		}
	}

	@Override
	public Student selectStuById(int stuId) {
		// TODO Auto-generated method stub
		return studentDao.selectStuById(stuId);
	}

	@Override
	public boolean updateStudent(int stuId, int classId, String stuName) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student = studentDao.selectStuById(stuId);

		Clas clas = new Clas();
		clas.setClassId(classId);
		student.setClas(clas);

		student.setStuName(stuName);

		// 修改
		try {
			studentDao.updateStudent(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("student 修改失败");
			return false;
		}
	}

}
