package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.dao.IDepartmentDao;
import cn.ltysyn.service.IDepartmentService;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements IDepartmentService {
	
	@Autowired
	private IDepartmentDao departmentDao;

	@Override
	public List<?> selectAllDepartment() {
		// TODO Auto-generated method stub
		return departmentDao.selectAllDepartment();
	}

}
