package cn.ltysyn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.dao.IAdminDao;
import cn.ltysyn.service.IAdminService;

@Service(value = "adminService")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;
	
	@Override
	public String checkPassword(String username) {
		// TODO Auto-generated method stub
		String password = adminDao.selectAdminByName(username).getPassword();
		return password;
	}

}
