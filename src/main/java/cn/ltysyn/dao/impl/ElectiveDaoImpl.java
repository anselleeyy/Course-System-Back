package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Elective;
import cn.ltysyn.dao.IElectiveDao;

@Repository
@Transactional
public class ElectiveDaoImpl implements IElectiveDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Elective> findElectives(int stuId) {
		// TODO Auto-generated method stub
		String hql = "from Elective where student.stuId = ?0";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, stuId);
		@SuppressWarnings("unchecked")
		List<Elective> list = (List<Elective>) query.getResultList();
		return list;
	}
	
	@Override
	public void saveElectives(Elective elective) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(elective);
	}

	@Override
	public void deleteElective(Elective elective) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(elective);
	}

}
