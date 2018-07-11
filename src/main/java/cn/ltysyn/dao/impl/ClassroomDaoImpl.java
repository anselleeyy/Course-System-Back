package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Classroom;
import cn.ltysyn.dao.IClassroomDao;

@Repository
@Transactional
public class ClassroomDaoImpl implements IClassroomDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Classroom> findAllClassrooms() {
		// TODO Auto-generated method stub
		String hql = "from Classroom";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Classroom> list = (List<Classroom>) query.getResultList();
		return list;
	}

}
