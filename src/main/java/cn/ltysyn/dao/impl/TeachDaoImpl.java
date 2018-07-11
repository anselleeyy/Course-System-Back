package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Teach;
import cn.ltysyn.dao.ITeachDao;

@Repository
@Transactional
public class TeachDaoImpl implements ITeachDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Teach> selectAllCourses() {
		// TODO Auto-generated method stub
		String hql = "from Teach";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Teach> list = (List<Teach>) query.getResultList();
		return list;
	}

	@Override
	public void addTeach(Teach teach) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(teach);
	}

	@Override
	public List<Teach> selectTeachsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		String hql = "from Teach where teacher.teaId = ?0";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, teaId);
		@SuppressWarnings("unchecked")
		List<Teach> list = (List<Teach>) query.getResultList();
		return list;
	}

	@Override
	public void deleteTeach(Teach teach) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(teach);
		
	}

	@Override
	public Teach selectTeachById(int teachId) {
		// TODO Auto-generated method stub
		String hql = "from Teach where id = ?0";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, teachId);
		Teach teach = (Teach) query.uniqueResult();
		return teach;
	}

}
