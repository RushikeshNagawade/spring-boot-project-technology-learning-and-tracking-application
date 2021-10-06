package technology.learning.and.tracking.application.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import technology.learning.and.tracking.application.Exception.CourseNotFoundException;
import technology.learning.and.tracking.application.Exception.IdNotFoundException;
import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.EventEntity;
import technology.learning.and.tracking.application.service.EventServiceInterface;

@RestController
public class EventController {
	private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private EventServiceInterface ei;
	
//	@Autowired
//	AdminServiceInterface adminService;
	
	@PostMapping("/eventcreate")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public EventEntity createEventByModerator(@RequestBody EventEntity ev) {
//		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
//				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		     return ei.EventRegisterService(ev);
//		throw new InvalidUserLoginException();
	}
	
	@GetMapping("/eventbyid/{eid}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<EventEntity> searchEventByid(@PathVariable("eid") int eid) {
		
		/*if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				(adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN"))) 
		{
			EventEntity eve = ei.findEventByEid(eid);
		    if(eve != null) {
			      return new ResponseEntity<EventEntity>(eve, HttpStatus.OK);
		     } 
		     else {
			      throw new IdNotFoundException();
		      }
		  //  throw new UsernamePasswordInvalidException();
	     }
		throw new InvalidUserLoginException();*/
		return ei.findEventByEid(eid);
	}
	
	@PutMapping("/updateevent")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public EventEntity updateEventByModeratorAdmin(@RequestBody EventEntity ev) {
//		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
//				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
			return ei.eventUpdateService(ev);
//		throw new InvalidUserLoginException();
//		LOG.info("updateCourse");
//		return ci.courseUpdateService(co);
	}
	
	//MODERATOR, ADMIN
		@Transactional
		@DeleteMapping("deleteevent/{eid}")
		@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		public int deleteEventByModeratorAdmin(@PathVariable("eid") int eid) {
//			if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
//					(adminService.loginStatus().getRole().toString().equals("ADMIN")))
			    return ei.deleteEvent(eid);
			//throw new InvalidUserLoginException();
		}
		
		//MOD TRAINEE ADMIN
		@GetMapping("/getallevents")
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		public ResponseEntity<List<EventEntity>> getAllEvents() {
			/*if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
					(adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
					(adminService.loginStatus().getRole().toString().equals("ADMIN")))
			{
				List<EventEntity> coe2 =  ei.getAllEvents();
			    if(coe2 != null) {
				      return new ResponseEntity<List<EventEntity>>(coe2, HttpStatus.OK);
			     } 
			     else {
				      throw new  CourseNotFoundException();
			     }
		     }
			
				throw new InvalidUserLoginException();  */
			return ei.getAllEvents();
		    }
}
