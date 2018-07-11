package cn.ltysyn.service;

import java.util.List;

import cn.ltysyn.bean.Teach;

public interface ITeachService {
	
	public List<Teach> selectAllCourses();
	
	public boolean addTeach(Teach teach);
	
	public List<Teach> selectTeachsByTeaId(int teaId);
	
	public boolean deleteTeach(int teachId);

}
