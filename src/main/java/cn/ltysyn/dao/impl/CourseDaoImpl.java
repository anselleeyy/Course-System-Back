package cn.ltysyn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Course;
import cn.ltysyn.dao.ICourseDao;

@Repository
@Transactional
public class CourseDaoImpl implements ICourseDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> selectAllCourse() {
		// TODO Auto-generated method stub
		String hql = "from Course";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<?> list = query.getResultList();
		return list;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(course);
		
	}


}
