package cn.ltysyn.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teach", schema = "ssh")
public class Teach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "time", nullable = false)
	private String time;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacher")
	private Teacher teacher;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course")
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "classroom")
	private Classroom classroom;
	
	@OneToMany(mappedBy = "teach", cascade = CascadeType.REMOVE)
	private Set<Elective> electives;
	
	public Teach() {
		super();
	}
	
	public Teach(int id, String time, Teacher teacher, Course course, Classroom classroom) {
		super();
		this.id = id;
		this.time = time;
		this.teacher = teacher;
		this.course = course;
		this.classroom = classroom;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Classroom getClassroom() {
		return classroom;
	}
	
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	@Override
	public String toString() {
		return "Elective [id=" + id + ", time=" + time + ", teacher=" + teacher + ", course=" + course + ", classroom="
				+ classroom + "]";
	}
	
}
