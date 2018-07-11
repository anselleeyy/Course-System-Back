package cn.ltysyn.dao;

import java.util.List;

import cn.ltysyn.bean.Classroom;

public interface IClassroomDao {
	
	public List<Classroom> findAllClassrooms();

}
