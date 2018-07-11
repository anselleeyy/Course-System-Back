package cn.ltysyn.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.bean.Classroom;
import cn.ltysyn.service.IClassroomService;

@Controller
@Scope(value = "prototype")
public class ClassroomAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2107965464024461140L;
	
	@Autowired
	private IClassroomService classroomService;
	
	private List<Classroom> classrooms;
	
	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public String getAllClassrooms() {
		
		classrooms = classroomService.findAllClassrooms();
		return SUCCESS;
	}

	
	
}
