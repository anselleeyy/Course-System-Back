package cn.ltysyn.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "course", schema = "ssh")
public class Course {
	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(name = "course_id")
	private int courseId;
	
	@Column(name = "course_name", nullable = false)
	private String courseName;
	
	@Column(name = "course_hour", length = 3, nullable = false)
	private int courseHour;
	
	@Column(name = "credit", length = 2, nullable = false)
	private double credit;
	
	@Column(name = "property", length = 20, nullable = false)
	private String property;
	
	@OneToMany(mappedBy = "course")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Teach> teachs;

	public Course() {
		super();
	}

	public Course(int courseId, String courseName, int courseHour, double credit,
			String property) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.credit = credit;
		this.property = property;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@JSON(serialize = false)
	public Set<Teach> getTeachs() {
		return teachs;
	}

	public void setTeachs(Set<Teach> teachs) {
		this.teachs = teachs;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePlace=" 
				+ ", courseHour=" + courseHour + ", credit=" + credit + ", property=" + property + "]";
	}

}
