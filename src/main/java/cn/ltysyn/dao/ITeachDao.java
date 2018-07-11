package cn.ltysyn.dao;

import java.util.List;

import cn.ltysyn.bean.Teach;

public interface ITeachDao {
	
	public List<Teach> selectAllCourses();
	
	public void addTeach(Teach teach);
	
	public List<Teach> selectTeachsByTeaId(int teaId);
	
	public void deleteTeach(Teach teach);
	
	public Teach selectTeachById(int teachId);

}
