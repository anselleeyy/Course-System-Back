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

@Entity
@Table(name = "student", schema = "ssh")
public class Student {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(name = "stu_id")
	private int stuId;

	@Column(name = "stu_name", length = 10, nullable = false)
	private String stuName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "birth_date", nullable = false)
	private String birthDate;
	
	@Column(name = "card_number", columnDefinition = "char(18)", nullable = false)
	private String cardNumber;
	
	@Column(name = "ethnic", length = 10, nullable = false)
	private String ethnic;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "class")
	private Clas clas;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
	private Set<Elective> electives;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int stuId, String stuName, String password, String birthDate, String cardNumber, String ethnic) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.password = password;
		this.birthDate = birthDate;
		this.cardNumber = cardNumber;
		this.ethnic = ethnic;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public Clas getClas() {
		return clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

	@JSON(serialize = false)
	public Set<Elective> getElectives() {
		return electives;
	}

	public void setElectives(Set<Elective> electives) {
		this.electives = electives;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", password=" + password + ", birthDate="
				+ birthDate + ", cardNumber=" + cardNumber + ", ethnic=" + ethnic + "]";
	}

}
