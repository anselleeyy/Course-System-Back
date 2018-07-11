package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.bean.Classroom;
import cn.ltysyn.dao.IClassroomDao;
import cn.ltysyn.service.IClassroomService;

@Service(value = "classroomService")
public class ClassroomServiceImpl implements IClassroomService {

	@Autowired
	private IClassroomDao classroomDao;
	
	@Override
	public List<Classroom> findAllClassrooms() {
		// TODO Auto-generated method stub
		return classroomDao.findAllClassrooms();
	}

}
