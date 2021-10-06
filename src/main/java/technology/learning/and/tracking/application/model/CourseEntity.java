package technology.learning.and.tracking.application.model;


import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "course")
public class CourseEntity {
	
	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
 	
	@Column
	private String cname;
	
	@Column(name= "course_details")
	private String courseDetails;

	@Column
	private double cfee;
	
	@Column(name="description")
	private String description;
	
	@Column(name="imageURL")
	private String imageURL;
	
	@Column(name="videoURL")
	private String videoURL;
	
	@Column
	private String material;
	
	
	public CourseEntity() {
		super();
	}


	public CourseEntity(String cname, String courseDetails, double cfee, String description) {
		super();
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
		this.description = description;
	}


	public CourseEntity(String cname, String courseDetails, double cfee, String description, String imageURL) {
		super();
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
		this.description = description;
		this.imageURL = imageURL;
	}


	public CourseEntity(int cid, String cname, String courseDetails, double cfee, String description) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
		this.description = description;
	}


	public CourseEntity(int cid, String cname, String courseDetails, double cfee, String description, String imageURL) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
		this.description = description;
		this.imageURL = imageURL;
	}
	
	


	public CourseEntity(String cname, String courseDetails, double cfee, String description, String imageURL,
			String videoURL, String material) {
		super();
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
		this.description = description;
		this.imageURL = imageURL;
		this.videoURL = videoURL;
		this.material = material;
	}
	
	

	public CourseEntity(int cid, String cname, String courseDetails, double cfee, String description, String imageURL,
			String videoURL) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
		this.description = description;
		this.imageURL = imageURL;
		this.videoURL = videoURL;
	}


	public CourseEntity(int cid, String cname, String courseDetails, double cfee, String description, String imageURL,
			String videoURL, String material) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
		this.description = description;
		this.imageURL = imageURL;
		this.videoURL = videoURL;
		this.material = material;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCourseDetails() {
		return courseDetails;
	}


	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}


	public double getCfee() {
		return cfee;
	}


	public void setCfee(double cfee) {
		this.cfee = cfee;
	}
	
	


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public String getVideoURL() {
		return videoURL;
	}


	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	@Override
	public String toString() {
		return "CourseEntity [cid=" + cid + ", cname=" + cname + ", courseDetails=" + courseDetails + ", cfee=" + cfee
				+ ", description=" + description + ", imageURL=" + imageURL + ", videoURL=" + videoURL
				+ ", material=" + material + "]";
	}


//	@Override
//	public String toString() {
//		return "CourseEntity [cid=" + cid + ", cname=" + cname + ", courseDetails=" + courseDetails + ", cfee=" + cfee
//				+ ", description=" + description + ", imageURL=" + imageURL + "]";
//	}



	
	

	
}