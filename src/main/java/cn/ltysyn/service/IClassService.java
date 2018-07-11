package cn.ltysyn.service;

import java.util.List;

import cn.ltysyn.bean.Clas;

public interface IClassService {

	public boolean addNewClass(Clas clas, int departmentId);
	
	public List<Clas> selectAllClass();
	
	public boolean updateClass(int claId, String claName, int depId, String specialty, int year);
	
	public boolean deleteClass(int claId);
	
	public Clas findClassById(int claId);
}
