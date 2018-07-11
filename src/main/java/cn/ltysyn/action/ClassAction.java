package cn.ltysyn.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.bean.Clas;
import cn.ltysyn.service.IClassService;

@Controller
@Scope("prototype")
public class ClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9220027458994168142L;

	@Autowired
	private IClassService classService;

	private List<Clas> cList;
	
	private Clas clas;

	private HttpServletRequest request;

	private String addStatus;
	
	private String delStatus;
	
	private String updateStatus;
	
	public String getAddStatus() {
		return addStatus;
	}
	
	public List<Clas> getClassList() {
		return cList;
	}
	
	public String getDelStatus() {
		return delStatus;
	}

	public String getUpdateStatus() {
		return updateStatus;
	}

	public Clas getClas() {
		return clas;
	}

	// 新增班级
	public String addClass() {
		request = ServletActionContext.getRequest();
		Clas clas = new Clas();
		clas.setClassName(request.getParameter("className"));
		clas.setSpecialty(request.getParameter("specialty"));
		clas.setYear(Integer.valueOf(request.getParameter("year")));
		int departmentId = Integer.valueOf(request.getParameter("departmentId"));
		boolean flag = classService.addNewClass(clas, departmentId);
		if (flag) {
			addStatus = "SUCCESS";
			return SUCCESS;
		} else {
			addStatus = "ERROR";
			return ERROR;
		}
		
	}
	
	// 返回班级信息
	public String findClasses() {
		cList = classService.selectAllClass();
		return SUCCESS;
	}
	
	// 删除班级
	public String delClass() {
		
		request = ServletActionContext.getRequest();
		String claId = request.getParameter("claId");
		System.out.println(claId);
		boolean flag = false;
		flag = classService.deleteClass(Integer.valueOf(claId));
		if (flag) {
			delStatus = "SUCCESS";
		} else {
			delStatus = "ERROR";
		}
		return SUCCESS;
	}
	
	public String updateClass() {
		
		request = ServletActionContext.getRequest();
		String claId = request.getParameter("claId");
		String claName = request.getParameter("claName");
		String depId = request.getParameter("depId");
		String specialty = request.getParameter("specialty");
		String year = request.getParameter("year");
		boolean flag = false;
		flag = classService.updateClass(Integer.valueOf(claId), claName, Integer.valueOf(depId), specialty, Integer.valueOf(year));
		if (flag) {
			updateStatus = "SUCCESS";
		} else {
			updateStatus = "ERROR";
		}
		
		return SUCCESS;
	}
	
	public String findClasById() {
		request = ServletActionContext.getRequest();
		String claId = request.getParameter("claId");
		clas = classService.findClassById(Integer.valueOf(claId));
		return SUCCESS;
	}
}
