 package technology.learning.and.tracking.application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "trainee")
public class TraineeEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	
	@Column
	
	private String fname;
	
	@Column
	private String lname;
	
	@Column
	private long phoneno;
	
	@Column
	private String qualification;
	
	@Column
	private String country;

	@Column
	private String status;
	
//	@ManyToOne(cascade = {CascadeType.ALL})
	@ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.PERSIST, CascadeType.REFRESH})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="user_id")
	private User user =  new User();
	
	 //mapping trainee with course
	@ManyToMany(cascade = {CascadeType.DETACH,  CascadeType.PERSIST, CascadeType.REFRESH})
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            joinColumns = @JoinColumn(name = "tid"),		
            inverseJoinColumns = @JoinColumn(name = "cid")
    )
	private List<CourseEntity> course;
	
	

	public TraineeEntity() {
		super();
	}

	public TraineeEntity(int tid, String fname, String lname, long phoneno, String qualification, String country,
			String status, User user, List<CourseEntity> course) {
		super();
		this.tid = tid;
		this.fname = fname;
		this.lname = lname;
		this.phoneno = phoneno;
		this.qualification = qualification;
		this.country = country;
		this.status = status;
		this.course = course;
		this.user = user;
	}

	public TraineeEntity(String fname, String lname, long phoneno, String qualification, String country, String status,
			 User user, List<CourseEntity> course) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phoneno = phoneno;
		this.qualification = qualification;
		this.country = country;
		this.status = status;
		this.course = course;
		this.user = user;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CourseEntity> getCourse() {
		return course;
	}

	public void setCourse(List<CourseEntity> course) {
		this.course = course;
	}

	public User getUser() {
		return  user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TraineeEntity [tid=" + tid + ", fname=" + fname + ", lname=" + lname + ", phoneno=" + phoneno
				+ ", qualification=" + qualification + ", country=" + country + ", status=" + status + ", user=" + user + "]";
	}

	
		

}
	
		

