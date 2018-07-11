package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.bean.Clas;
import cn.ltysyn.bean.Department;
import cn.ltysyn.dao.IClassDao;
import cn.ltysyn.service.IClassService;

@Service(value = "classService")
public class ClassServiceImpl implements IClassService {

	@Autowired
	private IClassDao classDao;
	
	@Override
	public boolean addNewClass(Clas clas, int departmentId) {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.setId(departmentId);
		clas.setDepartment(department);
		
		// 添加
		try {
			classDao.saveNewClass(clas);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("teacher 插入失败");
			return false;
		}
	}

	@Override
	public List<Clas> selectAllClass() {
		// TODO Auto-generated method stub
		List<Clas> list = classDao.selectAllClass();
		return list;
	}

	@Override
	public boolean updateClass(int claId, String claName, int depId, String specialty, int year) {
		// TODO Auto-generated method stub
		Clas clas = classDao.selectClassById(claId);
		clas.setClassName(claName);
		Department department = new Department();
		department.setId(depId);
		clas.setDepartment(department);
		clas.setSpecialty(specialty);
		clas.setYear(year);
		try {
			classDao.updateClass(clas);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("班级更新失败");
			return false;
		}
		
	}

	@Override
	public boolean deleteClass(int claId) {
		// TODO Auto-generated method stub
		Clas clas = classDao.selectClassById(claId);
		try {
			classDao.deleteClass(clas);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("班级删除失败");
			return false;
		}
	}

	@Override
	public Clas findClassById(int claId) {
		// TODO Auto-generated method stub
		return classDao.selectClassById(claId);
	}
	
	

}
