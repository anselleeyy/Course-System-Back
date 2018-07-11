package cn.ltysyn.dao;

import java.util.List;

import cn.ltysyn.bean.Course;

public interface ICourseDao {
	
	public List<?> selectAllCourse();
	
	public void addCourse(Course course);

}
