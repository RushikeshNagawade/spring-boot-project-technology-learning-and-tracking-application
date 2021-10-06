package technology.learning.and.tracking.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


import technology.learning.and.tracking.application.Exception.EmailNotFoundException;
import technology.learning.and.tracking.application.Exception.IdNotFoundException;
import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.TraineeEntity;
import technology.learning.and.tracking.application.model.User;
import technology.learning.and.tracking.application.service.TraineeServiceInterface;

@CrossOrigin(origins = "*", allowedHeaders="*")

@RequestMapping("/api")
@RestController
public class TraineeController {

	private static final Logger LOG = LoggerFactory.getLogger(TraineeController.class);

	@Autowired
	private TraineeServiceInterface ui;
	
	
	
	//TRAINEE
	//@Transactional
	@PostMapping("/createtrainee")
	@PreAuthorize("hasRole('USER')")
	
	public TraineeEntity createProfileByTrainee(@RequestBody TraineeEntity us) {
            return ui.userRegisterService(us);
		
	}
	


	//TRAINEE
	
	
	@Transactional
	@PutMapping("/updateuser/{tid}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public TraineeEntity updateUserByTrainee(@RequestBody TraineeEntity us,@PathVariable("tid") int tid) throws Exception{
        us.setTid(tid);     
		return ui.userUpdateService(us, tid);
		
	}
	
	@PutMapping("aprovestatus/{status}/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public TraineeEntity approvestatus(@PathVariable("status") String status,@PathVariable("id") int id) {
	 return ui.ApproveStatusService(status, id);
	
				
	}
	
	
	
	
	
	//ADMIN, USER
	@GetMapping("/findtrainee/{tid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATOR')")
	public TraineeEntity searchTraineeTidByAdminTrainee(@PathVariable("tid") int tid) {
		
		
		return ui.findTraineeByTid(tid);
	}
	
	//ADMIN, USER
	@Transactional
	@DeleteMapping("deleteuser/{tid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public int deleteTraineeByAdminTrainee(@PathVariable("tid") int tid) {
         return ui.deleteTrainee(tid);
	}
	
	//ADMIN, USER
	@GetMapping("/getalltrainees")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATOR')")
	public List<TraineeEntity> getAllTraineesByAdminTrainee() {
		return ui.getAllTrainees();
		
	    
	}
	
	//ADMIN
		@GetMapping("/usersearchstatus/{status}")
		@PreAuthorize("hasRole('ADMIN')")
		public List<TraineeEntity> userSearchStatusByAdmin(@PathVariable("status") String status) {
             return ui.usersearchbystatusService(status);
			
		}
		
		
		
		
		// Apply for job
		@GetMapping("/applyForCourse/{tid}")
		@PreAuthorize("hasRole('MODERATOR') or hasRole('USER')")
		public String apply(@PathVariable("tid") int tid) {
			LOG.info("Applied for a Course");
             return ui.applyForCourse(tid);
       }

	
}