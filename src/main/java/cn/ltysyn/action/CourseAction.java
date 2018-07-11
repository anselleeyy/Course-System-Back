package cn.ltysyn.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.service.ICourseService;

@Controller
public class CourseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 867079424657066386L;
	
	@Autowired
	private ICourseService courseService;
	
//	private List<Course> courses;
	private List<?> courses;

	public List<?> getCourses() {
		return courses;
	}
	
	public String selectAllCourse() {
		
		courses = courseService.selectAllCourse();
		return SUCCESS;
	}
	
	

}
