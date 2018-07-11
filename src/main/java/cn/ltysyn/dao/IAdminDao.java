package cn.ltysyn.dao;

import cn.ltysyn.bean.Admin;

public interface IAdminDao {
	
	public Admin selectAdminByName(String username);
	
	public int checkIfSelect();
	
	public boolean setSelect(int value);

}
