package cn.ltysyn.service;

import java.util.List;

import cn.ltysyn.bean.Course;

public interface ICourseService {
	
	public List<?> selectAllCourse();
	
	public boolean addCourse(Course course);

}
