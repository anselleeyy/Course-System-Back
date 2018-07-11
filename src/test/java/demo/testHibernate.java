package demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import cn.ltysyn.bean.Elective;
import cn.ltysyn.bean.Student;
import cn.ltysyn.bean.Teach;
import cn.ltysyn.bean.Teacher;
import cn.ltysyn.dao.IAdminDao;
import cn.ltysyn.dao.IElectiveDao;
import cn.ltysyn.dao.IStudentDao;
import cn.ltysyn.dao.ITeachDao;
import cn.ltysyn.dao.ITeacherDao;
import cn.ltysyn.service.ICourseService;
import cn.ltysyn.service.IDepartmentService;
import cn.ltysyn.service.IStudentService;
import cn.ltysyn.service.ITeacherService;
import cn.ltysyn.util.Enctype;

@SpringJUnitConfig
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class testHibernate {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private IElectiveDao electiveDao;
	
	@Autowired
	private IStudentDao studentDao;
	
	@SuppressWarnings("unused")
	@Autowired
	private IStudentService studentService;
	
	@SuppressWarnings("unused")
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private ITeacherDao teacherDao;
	
	@Autowired
	private ITeachDao teachDao;
	
	@Autowired
	private IAdminDao adminDao;
	
	@Test
	public void test4() {
		List<?> list = departmentService.selectAllDepartment();
		System.out.println(list);
	}
	
	@Test
	public void test5() {
		List<Teacher> list = (List<Teacher>) teacherService.selectAllTeacher();
		Hibernate.initialize(list.get(0).getDepartment());
		System.out.println(list.get(0).getDepartment());
	}
	
	@Test
	public void test6() {
		Enctype enctype = new Enctype();
		System.out.println(enctype.MD5("admin"));
	}
	
	@Test
	public void test7() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.toString());
	}
	
	@Test
	public void test8() {
		List<Elective> list = electiveDao.findElectives(15130306);
		System.out.println(list);
	}
	
	@Test
	public void test9() {
		Student student = studentDao.selectStuById(15130306);
		student.setPassword("21232F297A57A5A743894A0E4A801FC3");
		studentDao.updatePwd(student);
	}
	
	@Test
	public void test10() {
		Student student = new Student();
		student.setStuId(15130306);
		Teach teach = new Teach();
		teach.setId(1);
		Elective elective = new Elective();
		elective.setStudent(student);
		elective.setTeach(teach);
		electiveDao.deleteElective(elective);
	}
	
	@Test
	public void test11() {
		Teacher teacher = teacherDao.selectTeacherById(2015098);
		System.out.println(teacher);
		boolean flag = teacherService.deleteTeacher(2015099);
		System.out.println(flag);
	}
	
	@Test
	public void test12() {
		List<Teach> teachs = teachDao.selectTeachsByTeaId(2014021);
		System.out.println(teachs);
	}
	
	@Test
	public void test13() {
		int i = adminDao.checkIfSelect();
		System.out.println("更新前：" + i);
		adminDao.setSelect(i == 0 ? 1 : 0);
		i = adminDao.checkIfSelect();
		System.out.println("更新后：" + i);
	}


}
