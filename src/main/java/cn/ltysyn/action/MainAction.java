package cn.ltysyn.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.bean.Student;
import cn.ltysyn.dao.IAdminDao;
import cn.ltysyn.service.IAdminService;
import cn.ltysyn.service.IStudentService;
import cn.ltysyn.service.ITeacherService;
import cn.ltysyn.util.Enctype;

@Controller
@Scope("prototype")
public class MainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Student student;
	
	private String loginStatus;
	
	private String resetStatus;
	
	private String updateStatus;
	
	private int sysStatus;
	
	public Student getStudent() {
		return student;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public String getResetStatus() {
		return resetStatus;
	}

	public String getUpdateStatus() {
		return updateStatus;
	}

	public int getSysStatus() {
		return sysStatus;
	}

	private HttpServletRequest request = ServletActionContext.getRequest();
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IAdminDao adminDao;
	
	private Enctype enctype = new Enctype();
	
	public String login() {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		password = enctype.MD5(password);
		String ident = request.getParameter("ident");
		String realPassword = "";
		if (username == null || password == null || ident == null) {
			loginStatus = "ERROR";
			return SUCCESS;
		}
		if (Integer.valueOf(ident) == 0) {
			realPassword = studentService.checkPassword(Integer.valueOf(username));
		} else if (Integer.valueOf(ident) == 1) {
			realPassword = teacherService.checkPassword(Integer.valueOf(username));
		} else {
			realPassword = adminService.checkPassword(username);
		}
		if (password != null && password.equals(realPassword)) {
			loginStatus = "SUCCESS";
			return SUCCESS;
		} else {
			loginStatus = "ERROR";
			return SUCCESS;
		}
	}
	
	public String reset() {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String username = request.getParameter("username");
		String ident = request.getParameter("ident");
		System.out.println(newPassword + " " + username + " " + ident);
		boolean result = false;
		String realPassword = "";
		if (Integer.valueOf(ident) == 0) {
			realPassword = studentService.checkPassword(Integer.valueOf(username));
		} else if (Integer.valueOf(ident) == 1) {
			realPassword = teacherService.checkPassword(Integer.valueOf(username));
		} else {
			realPassword = adminService.checkPassword(username);
		}
		Enctype enctype = new Enctype();
		oldPassword = enctype.MD5(oldPassword);
		if (!realPassword.equals(oldPassword)) {
			resetStatus = "PWDERROR";
			return SUCCESS;
		}

		if (Integer.valueOf(ident) == 0) {
			result = studentService.updatePwd(newPassword, Integer.valueOf(username));
		} else {
			result = teacherService.updatePwd(newPassword, Integer.valueOf(username));
		}
		
		if (result) {
			resetStatus = "SUCCESS";
			return SUCCESS;
		} else {
			resetStatus = "ERROR";
			return SUCCESS;
		}
	}
	
	public String returnSys() {
		
		sysStatus = adminDao.checkIfSelect();
		return SUCCESS;
	}
	
	public String updateSys() {
		
		int i = adminDao.checkIfSelect();
		boolean flag = adminDao.setSelect(i == 0 ? 1 : 0);
		if (flag) {
			updateStatus = "SUCCESS";
		} else {
			updateStatus = "ERROR";
		}
		return SUCCESS;
	}

}
