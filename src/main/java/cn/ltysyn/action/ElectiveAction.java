package cn.ltysyn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.bean.Elective;
import cn.ltysyn.service.IElectiveService;

@Controller
@Scope(value = "prototype")
public class ElectiveAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 229853319535066984L;
	
	private HttpServletRequest request;
	
	private String delStatus;
	
	private String addStatus;
	
	@Autowired
	private IElectiveService electiveService;
	
	private List<Elective> electives;
	
	public List<Elective> getElectives() {
		return electives;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public String getAddStatus() {
		return addStatus;
	}

	public String findAllElectives() {
		
		request = ServletActionContext.getRequest();
		String stuId = request.getParameter("username");
		if (stuId != null) {
			electives = electiveService.getElectives(Integer.valueOf(stuId));
		}
		
		return SUCCESS;
	}
	
	public String addElective() {
		request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String teachId = request.getParameter("teachId");
		boolean flag = true;
		
		if (username != null && teachId != null) {
			flag = electiveService.addElective(Integer.valueOf(username), Integer.valueOf(teachId));
		}
		if (flag) {
			addStatus = "SUCCESS";
		} else {
			addStatus = "ERROR";
		}
		return SUCCESS;
	}
	
	public String deleteElective() {
		request = ServletActionContext.getRequest();
		String eleId = request.getParameter("electiveId");
		boolean flag = true;
		if (eleId != null) {
			flag = electiveService.deleteElective(Integer.valueOf(eleId));	
		}
		if (flag) {
			delStatus = "SUCCESS";
		} else {
			delStatus = "ERROR";
		}
		return SUCCESS;
	}

}
