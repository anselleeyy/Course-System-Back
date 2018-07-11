package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.dao.IDepartmentDao;

@Repository
@Transactional
public class DepartmentDaoImpl implements IDepartmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> selectAllDepartment() {
		// TODO Auto-generated method stub
		String hql = "from Department";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<?> list = query.getResultList();
		return list;
	}

}
