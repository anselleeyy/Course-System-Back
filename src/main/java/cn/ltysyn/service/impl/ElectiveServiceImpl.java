package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.bean.Elective;
import cn.ltysyn.bean.Student;
import cn.ltysyn.bean.Teach;
import cn.ltysyn.dao.IElectiveDao;
import cn.ltysyn.service.IElectiveService;

@Service(value = "electiveService")
public class ElectiveServiceImpl implements IElectiveService {

	@Autowired
	private IElectiveDao electiveDao;
	
	@Override
	public List<Elective> getElectives(int stuId) {
		// TODO Auto-generated method stub
		return electiveDao.findElectives(stuId);
	}
	
	@Override
	public boolean addElective(int userName, int teachId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStuId(userName);
		Teach teach = new Teach();
		teach.setId(teachId);
		Elective elective = new Elective();
		elective.setStudent(student);
		elective.setTeach(teach);
		try {
			electiveDao.saveElectives(elective);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("xxx");
			return false;
		}
		
	}

	@Override
	public boolean deleteElective(int eleId) {
		// TODO Auto-generated method stub
		Elective elective = new Elective();
		elective.setId(eleId);
		try {
			electiveDao.deleteElective(elective);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("退课失败");
			return false;
		}

	}


}
