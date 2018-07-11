package cn.ltysyn.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "teacher", schema = "ssh")
public class Teacher {
	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(name = "tea_id")
	private int teaId;
	
	@Column(name = "tea_name", length = 10, nullable = false)
	private String teaName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "sex", columnDefinition = "char(2)", nullable = false)
	private String sex;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Teach> teachs;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department")
	private Department department;
	
	public Teacher() {
		super();
	}

	public Teacher(int teaId, String teaName, String password, String sex) {
		super();
		this.teaId = teaId;
		this.teaName = teaName;
		this.password = password;
		this.sex = sex;
	}

	public int getTeaId() {
		return teaId;
	}

	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@JSON(serialize = false)
	public Set<Teach> getTeachs() {
		return teachs;
	}

	public void setTeachs(Set<Teach> teachs) {
		this.teachs = teachs;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Teacher [teaId=" + teaId + ", teaName=" + teaName + ", password=" + password + ", sex=" + sex + "]";
	}
	
}
