package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.bean.Department;
import cn.ltysyn.bean.Teacher;
import cn.ltysyn.dao.ITeacherDao;
import cn.ltysyn.service.ITeacherService;
import cn.ltysyn.util.Enctype;

@Service(value = "teacherService")
public class TeacherServiceImpl implements ITeacherService {

	@Autowired
	private ITeacherDao teacherDao;
	
	private Enctype enctype = new Enctype();
	
	@Override
	public boolean addNewTeacher(Teacher teacher, int departmentId) {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.setId(departmentId);
		teacher.setDepartment(department);
		
		// 密码部分
		String password = "";
		password = enctype.MD5("123456");
		teacher.setPassword(password);
		
		// 添加
		try {
			teacherDao.saveNewTeacher(teacher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("teacher 插入失败");
			return false;
		}
	}

	@Override
	public List<Teacher> selectAllTeacher() {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDao.selectAllTeacher();
		return list;
	}

	@Override
	public String checkPassword(int teaId) {
		// TODO Auto-generated method stub
		String password = teacherDao.selectTeacherById(teaId).getPassword();
		return password;
	}

	@Override
	public boolean updatePwd(String password, int teaId) {
		// TODO Auto-generated method stub
		password = enctype.MD5(password);
		Teacher teacher = teacherDao.selectTeacherById(teaId);
		teacher.setPassword(password);
		
		try {
			teacherDao.updatePwd(teacher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("教师密码更新失败");
			return false;
		}
	}

	@Override
	public boolean deleteTeacher(int teaId) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher = teacherDao.selectTeacherById(teaId);
		try {
			teacherDao.deleteTeacher(teacher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("教师 删除失败");
			return false;
		}

	}

	@Override
	public Teacher selectTeacherById(int teaId) {
		// TODO Auto-generated method stub
		return teacherDao.selectTeacherById(teaId);
	}

	@Override
	public boolean updateTeacher(int teaId, int depId, String teaName) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDao.selectTeacherById(teaId);
		System.out.println(teacher);
		Department department = new Department();
		department.setId(depId);
		teacher.setDepartment(department);
		teacher.setTeaName(teaName);
		try {
			teacherDao.updateTeacher(teacher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("教师更新失败");
			return false;
		}
	}

}
