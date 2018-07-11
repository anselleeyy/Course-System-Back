package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Clas;
import cn.ltysyn.dao.IClassDao;

@Repository
@Transactional
public class ClassDaoImpl implements IClassDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveNewClass(Clas clas) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(clas);
	}

	@Override
	public List<Clas> selectAllClass() {
		// TODO Auto-generated method stub
		String hql = "from Clas";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Clas> list = (List<Clas>) query.getResultList();
		return list;
	}

	@Override
	public void updateClass(Clas clas) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(clas);
		
	}

	@Override
	public void deleteClass(Clas clas) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(clas);
		
	}

	@Override
	public Clas selectClassById(int claId) {
		// TODO Auto-generated method stub
		String hql = "from Clas where classId = ?0";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, claId);
		Clas clas = (Clas) query.uniqueResult();
		return clas;
	}

}
