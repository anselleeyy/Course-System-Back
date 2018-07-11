package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Student;
import cn.ltysyn.dao.IStudentDao;

@Repository
@Transactional
public class StudentDaoImpl implements IStudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Student selectStuById(int stuId) {
		// TODO Auto-generated method stub
		return (Student) sessionFactory.getCurrentSession().createQuery("from Student where id = ?0").setParameter(0, stuId).uniqueResult();
	}

	@Override
	public void saveNewStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(student);
	}

	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		String hql = "from Student";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) query.getResultList();
		return list;
	}

	@Override
	public void updatePwd(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(student);
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(student);
	}
	
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(student);
	}

}
