package cn.ltysyn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.bean.Classroom;
import cn.ltysyn.bean.Course;
import cn.ltysyn.bean.Teach;
import cn.ltysyn.bean.Teacher;
import cn.ltysyn.service.ICourseService;
import cn.ltysyn.service.ITeachService;

public class TeachAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6943996004825376460L;
	
	@Autowired
	private ITeachService teachService;
	
	@Autowired
	private ICourseService courseService;
	
	private List<Teach> teachs;
	
	private String addStatus;
	
	private String delStatus;
	
	private HttpServletRequest request;
	
	public List<Teach> getTeachs() {
		return teachs;
	}
	
	public String getAddStatus() {
		return addStatus;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public String findAllTeaches() {
		teachs = teachService.selectAllCourses();
		return SUCCESS;
	}
	
	public String addTeach() {
		
		request = ServletActionContext.getRequest();
		String courseName = request.getParameter("courseName");
        String courseId = request.getParameter("courseId");
        String teacherId = request.getParameter("teacherId");
        String claId = request.getParameter("claId");
        String teachLesson = request.getParameter("teachLesson");
        String credit = request.getParameter("credit");
        String property = request.getParameter("property");
        String courseHour = request.getParameter("courseHour");
        
        boolean flagCourse = false;
        boolean flagTeach = false;
        
        Course course = new Course(Integer.valueOf(courseId), courseName, Integer.valueOf(courseHour), Double.valueOf(credit), property);
        flagCourse = courseService.addCourse(course);
        
        Teach teach = new Teach();
        Classroom classroom = new Classroom();
        classroom.setClaId(Integer.valueOf(claId));
        Teacher teacher = new Teacher();
        teacher.setTeaId(Integer.valueOf(teacherId));
        teach.setClassroom(classroom);
        teach.setCourse(course);
        teach.setTeacher(teacher);
        teach.setTime(teachLesson);
        flagTeach = teachService.addTeach(teach);
        
        if (flagCourse && flagTeach) {
			addStatus = "SUCCESS";
		} else {
			addStatus = "ERROR";
		}
        
        return SUCCESS;
        
	}
	
	public String findTeachsByTeaId() {
		
		request = ServletActionContext.getRequest();
		
		String teaId = request.getParameter("teaId");
		teachs = teachService.selectTeachsByTeaId(Integer.valueOf(teaId));
		
		return SUCCESS;
	}
	
	public String deleteTeach() {
		
		request = ServletActionContext.getRequest();
		String teachId = request.getParameter("teachId");
		boolean flag = false;
		flag = teachService.deleteTeach(Integer.valueOf(teachId));
		if (flag) {
			delStatus = "SUCCESS";
		} else {
			delStatus = "ERROR";
		}
		
		return SUCCESS;
	}

}
