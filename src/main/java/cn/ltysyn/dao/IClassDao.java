package cn.ltysyn.dao;

import java.util.List;

import cn.ltysyn.bean.Clas;

public interface IClassDao {
	
	public void saveNewClass(Clas clas);
	
	public List<Clas> selectAllClass();
	
	public void updateClass(Clas clas);
	
	public void deleteClass(Clas clas);
	
	public Clas selectClassById(int claId);

}
