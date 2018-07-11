package cn.ltysyn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.ltysyn.bean.Student;
import cn.ltysyn.service.IStudentService;

@Controller
@Scope("prototype")
public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2642646425776203168L;

	@Autowired
	private IStudentService studentService;
	
	private Student student;
	
	private List<Student> studentList;
	
	private HttpServletRequest request;
	
	private String addStatus;
	
	private String delStatus;
	
	private String updateStatus;
	
	public String getAddStatus() {
		return addStatus;
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public String getUpdateStatus() {
		return updateStatus;
	}

	public Student getStudent() {
		return student;
	}

	// 新增学生
	public String addStudent() {
		
		request = ServletActionContext.getRequest();
		student = new Student();
		student.setStuName(request.getParameter("stuName"));
		student.setStuId(Integer.valueOf(request.getParameter("stuId")));
		student.setCardNumber(request.getParameter("cardNumber"));
		student.setBirthDate(request.getParameter("birthDate"));
		student.setEthnic(request.getParameter("ethnic"));
		String classId = request.getParameter("classId");
		System.out.println("student: " + student);
		System.out.println("classId:" + classId);
		boolean flag = studentService.addNewStudent(student, Integer.valueOf(classId));
		if (flag) {
			addStatus = "SUCCESS";
			return SUCCESS;
		} else {
			addStatus = "ERROR";
			return ERROR;
		}
	}
	
	// 返回学生信息
	public String findStudents() {
		studentList = studentService.selectAllStudent();
		return SUCCESS;
	}
	
	public String deleteStudent() {
		request = ServletActionContext.getRequest();
		boolean flag = studentService.deleteStudent(Integer.valueOf(request.getParameter("stuId")));
		if (flag) {
			delStatus = "SUCCESS";
			return SUCCESS;
		} else {
			delStatus = "ERROR";
			return ERROR;
		}
	}
	
	// 查询一个学生信息
	public String findStudentById() {
		request = ServletActionContext.getRequest();
		String stuId = request.getParameter("stuId");
		student = studentService.selectStuById(Integer.valueOf(stuId));
		return SUCCESS;
	}
	
	// 修改学生
	public String updateStudent() {
		request = ServletActionContext.getRequest();
		boolean flag = studentService.updateStudent(Integer.valueOf(request.getParameter("stuId")),
				Integer.valueOf(request.getParameter("claId")), request.getParameter("stuName"));
		if (flag) {
			updateStatus = "SUCCESS";
			return SUCCESS;
		} else {
			updateStatus = "ERROR";
			return ERROR;
		}
	}

}
