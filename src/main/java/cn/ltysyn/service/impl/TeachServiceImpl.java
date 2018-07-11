package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.bean.Teach;
import cn.ltysyn.dao.ITeachDao;
import cn.ltysyn.service.ITeachService;

@Service(value = "teachService")
public class TeachServiceImpl implements ITeachService {

	@Autowired
	private ITeachDao teachDao;
	
	@Override
	public List<Teach> selectAllCourses() {
		// TODO Auto-generated method stub
		return teachDao.selectAllCourses();
	}

	@Override
	public boolean addTeach(Teach teach) {
		// TODO Auto-generated method stub
		try {
			teachDao.addTeach(teach);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("授课情况添加失败");
			return false;
		}
	}

	@Override
	public List<Teach> selectTeachsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		return teachDao.selectTeachsByTeaId(teaId);
	}

	@Override
	public boolean deleteTeach(int teachId) {
		// TODO Auto-generated method stub
		Teach teach = teachDao.selectTeachById(teachId);
		try {
			teachDao.deleteTeach(teach);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("授课情况删除失败");
			return false;
		}
	}

	
}
