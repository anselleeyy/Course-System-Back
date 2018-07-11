package cn.ltysyn.service;

import java.util.List;

import cn.ltysyn.bean.Elective;

public interface IElectiveService {
	
	public List<Elective> getElectives(int stuId);
	
	public boolean addElective(int userName, int teachId);
	
	public boolean deleteElective(int eleId);

}
