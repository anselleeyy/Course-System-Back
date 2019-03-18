package cn.ltysyn.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ltysyn.bean.Admin;
import cn.ltysyn.dao.IAdminDao;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Admin selectAdminByName(String username) {
		// TODO Auto-generated method stub
		String hql = "from Admin where username = ?0";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, username);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}

	@Override
	public int checkIfSelect() {
		// TODO Auto-generated method stub
		String sql = "select ifSelect from syscontrol";
		Integer result = (Integer) sessionFactory.getCurrentSession().createNativeQuery(sql).uniqueResult();
		return result;
	}

	@Override
	public boolean setSelect(int value) {
		// TODO Auto-generated method stub
		
		String sql = "update syscontrol set ifSelect = " + value;
		try {
			NativeQuery<?> query = sessionFactory.getCurrentSession().createNativeQuery(sql);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("系统表更新失败！");
			return false;
		}
		
	}

	
}
