package cn.ltysyn.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.service.IDepartmentService;

public class DepartmentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6622112422782815597L;
	
	private List<?> departmentList;
	
	public List<?> getDepartmentList() {
		return departmentList;
	}

	@Autowired
	private IDepartmentService departmentService;
	
	public String getAllDepartment() {
		departmentList = departmentService.selectAllDepartment();
		
		return SUCCESS;
	}

}
