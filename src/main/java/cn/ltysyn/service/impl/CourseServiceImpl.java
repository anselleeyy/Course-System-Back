package cn.ltysyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ltysyn.bean.Course;
import cn.ltysyn.dao.ICourseDao;
import cn.ltysyn.service.ICourseService;

@Service(value = "courseService")
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private ICourseDao courseDao;
	
	public List<?> selectAllCourse() {
		return courseDao.selectAllCourse();
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			courseDao.addCourse(course);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("增加课程失败");
			return false;
		}
	}

}
