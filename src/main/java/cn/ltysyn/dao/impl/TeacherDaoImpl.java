package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Teacher;
import cn.ltysyn.dao.ITeacherDao;

@Transactional
@Repository
public class TeacherDaoImpl implements ITeacherDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveNewTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(teacher);
	}

	@Override
	public List<Teacher> selectAllTeacher() {
		// TODO Auto-generated method stub
		String hql = "from Teacher";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Teacher> list = (List<Teacher>) query.getResultList();
		return list;
	}

	@Override
	public Teacher selectTeacherById(int teaId) {
		// TODO Auto-generated method stub
		String hql = "from Teacher where teaId = ?0";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, teaId);
		Teacher teacher = (Teacher) query.uniqueResult();
		return teacher;
	}

	@Override
	public void updatePwd(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(teacher);
	}
	
	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(teacher);
	}

}
