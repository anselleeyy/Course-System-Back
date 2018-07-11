package cn.ltysyn.dao;

import java.util.List;

import cn.ltysyn.bean.Elective;

public interface IElectiveDao {
	
	public List<Elective> findElectives(int stuId);
	
	public void saveElectives(Elective elective);
	
	public void deleteElective(Elective elective);


}
