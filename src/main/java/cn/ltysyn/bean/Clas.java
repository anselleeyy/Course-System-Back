package cn.ltysyn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "class", schema = "ssh")
public class Clas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id")
	private int classId;
	
	@Column(name = "class_name", length = 50, nullable = false)
	private String className;
	
	@Column(name = "specialty", length = 30, nullable = false)
	private String specialty;
	
	@Column(name = "year", nullable = false)
	private int year;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department")
	private Department department;

	public Clas() {
		super();
	}

	public Clas(int classId, String className, String specialty, int year) {
		super();
		this.classId = classId;
		this.className = className;
		this.specialty = specialty;
		this.year = year;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Clas [classId=" + classId + ", className=" + className + ", specialty=" + specialty + ", year=" + year
				+ ", department=" + department + "]";
	}

}
