package cn.ltysyn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.service.ITeacherService;
import cn.ltysyn.bean.Teacher;

@Controller
@Scope(value = "prototype")
public class TeacherAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7993519599611639742L;
	
	@Autowired
	private ITeacherService teacherService;
	
	private Teacher teacher;
	
	private List<Teacher> teacherList;
	
	private HttpServletRequest request;
	
	private String addStatus;
	
	private String delStatus;
	
	private String updateStatus;

	public String getAddStatus() {
		return addStatus;
	}

	public String getDelStatus() {
		return delStatus;
	}
	
	public String getUpdateStatus() {
		return updateStatus;
	}
	
	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	// 新增教师
	public String addTeacher() {
		
		request = ServletActionContext.getRequest();
		String teaName = request.getParameter("teaName");
		String sex = request.getParameter("sex");
		String teaId = request.getParameter("teaId");
		teacher = new Teacher();
		teacher.setTeaName(teaName);
		teacher.setSex(sex);
		teacher.setTeaId(Integer.valueOf(teaId));
		String departmendId = request.getParameter("departmentId");
		boolean flag = teacherService.addNewTeacher(teacher, Integer.valueOf(departmendId));
		if (flag) {
			addStatus = "SUCCESS";
		} else {
			addStatus = "ERROR";
		}
		return SUCCESS;

	}
	
	// 返回教师信息
	public String findTeachers() {
		
		teacherList = teacherService.selectAllTeacher();
		return SUCCESS;
	}
	
	//删除教师                                                                                          
	public String deleteTeacher() {
		request = ServletActionContext.getRequest();
		String teaId = request.getParameter("teaId");
		if (teaId == null) {
			delStatus = "ERROR";
			return SUCCESS;
		}
		boolean flag = teacherService.deleteTeacher(Integer.valueOf(teaId));
		if (flag) {
			delStatus = "SUCCESS";
		} else {
			delStatus = "ERROR";
		}
		return SUCCESS;
	}
	
	// 获取单个老师信息
	public String findTeacherById() {
		request = ServletActionContext.getRequest();
		String teaId = request.getParameter("teaId");
		teacher = teacherService.selectTeacherById(Integer.valueOf(teaId));
		return SUCCESS;
	}
	
	// 修改教师
	public String updateTeacher() {
		request = ServletActionContext.getRequest();
		boolean flag = teacherService.updateTeacher(Integer.valueOf(request.getParameter("teaId")),
				Integer.valueOf(request.getParameter("depId")), request.getParameter("teaName"));
		if (flag) {
			updateStatus = "SUCCESS";
			return SUCCESS;
		} else {
			updateStatus = "ERROR";
			return ERROR;
		}
	}


}
