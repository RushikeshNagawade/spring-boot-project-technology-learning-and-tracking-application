package technology.learning.and.tracking.application.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import technology.learning.and.tracking.application.Exception.CourseNotFoundException;
import technology.learning.and.tracking.application.Exception.IdNotFoundException;
import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.User;
import technology.learning.and.tracking.application.service.CourseServiceInterface;

@CrossOrigin(origins = "*", allowedHeaders="*")

@RequestMapping("/api")
@RestController
public class CourseController {

	private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseServiceInterface ci;
	
	@Transactional
	@PostMapping("/coursecreate")
	@PreAuthorize("hasRole('MODERATOR')")
	public CourseEntity createCourseByModerator(@RequestBody CourseEntity md) {
           return ci.courseRegisterService(md);
	}

	@GetMapping("/coursebyid/{cid}")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
	public CourseEntity searchCourseByModeratorTrainee(@PathVariable("cid") int cid) {
		return  ci.findCourseByCid(cid);
	}
		
		
   	  
		
	
	
	
	
	@GetMapping("/coursebyname/{cname}")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
	public List<CourseEntity> searchCourseCnameByModeratorTrainee(@PathVariable("cname") String cname)
	{
		return ci.findCourseByCname(cname);
	}
	
	
	
	@Transactional
	@PutMapping("/updatecourse/{cid}")
	
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	public CourseEntity updateCourseByModerator(@RequestBody CourseEntity cs,@PathVariable("cid") int cid) throws Exception{
		LOG.info("updateCourse");
		LOG.error("updateCourse");
		cs.setCid(cid);
		
		return ci.courseUpdateService(cs, cid);
	}
	
	//MODERATOR
	@Transactional
	@DeleteMapping("deletecourse/{cid}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public String deleteCourseByModerator(@PathVariable("cid") int cid) {
	
		String str="user not deleted";
		CourseEntity ce = ci.deleteCourse(cid);
		if(ce == null) {
			
			str="user deleted";
		}
		return str;    
		
	
	}
	
	//MOD TRAINEE
	@GetMapping("/getallcourses")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<CourseEntity> getAllCoursesByModeratorTrainee() {
		return ci.getAllCourses();
	}

}
	
	

