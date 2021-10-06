package technology.learning.and.tracking.application.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import technology.learning.and.tracking.application.model.User;
import technology.learning.and.tracking.application.service.ModeratorServiceInterface;



import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;




@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("api")

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ModeratorController {
	
private static final Logger LOG = LoggerFactory.getLogger(ModeratorController.class);
	
	@Autowired
	private ModeratorServiceInterface mi;
	
//	@Autowired
//	AdminServiceInterface adminService;
	
	//MOD
	@PostMapping("/createuser")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public User createProfileByModerator(@RequestBody User md) {
//		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
//				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
			return mi.moderatorRegisterService(md);
//		throw new InvalidUserLoginException();
	}
	


	// search moderator my mid
	@GetMapping("/searchmod/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public User searchModeratorMidByModerator(@PathVariable("id") int id) {
		/* if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		{
			ModeratorEntity coe =  mi.findModeratorByMid(mid);
			if(coe != null) {
				return new ResponseEntity<ModeratorEntity>(coe, HttpStatus.OK);
			}
			else {
				 throw new IdNotFoundException();
			}
		}
		throw new InvalidUserLoginException();*/
		return mi.findModeratorById(id);
	}
	
	
	// search moderator my mid
		@GetMapping("/searchmodemail/{email}")
		@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		public User searchModeratorMemailByModeratorAdmin(@PathVariable("email") String email) {
			/* if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
					(adminService.loginStatus().getRole().toString().equals("ADMIN")))
			{
				ModeratorEntity coe =  mi.findModeratorByMemail(memail);
				if(coe != null) {
					return new ResponseEntity<ModeratorEntity>(coe, HttpStatus.OK);
				}
				else {
					 throw new EmailNotFoundException();
				}
			}
			throw new InvalidUserLoginException();*/
			return mi.findModeratorByEmail(email);
		}
	
	//MOD
	@PutMapping("/updatemoderator/{id}")
	//@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public User updateModeratorByModerator(@RequestBody User us,@PathVariable("id") Long id) throws Exception{
//		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
//				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		     return mi.modUpdateService(us, id);
		//throw new InvalidUserLoginException();
	}
	
	// MOD
	@Transactional
	@DeleteMapping("deletemoderator/{id}")
	//@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public String deleteModeratorByModerator(@PathVariable("id") int id) {
//		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
//				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		String str="user not deleted";
		User u = mi.deleteModerator(id);
		if(u == null) {
			
			str="user deleted";
		}
		return str;    
		
//		throw new InvalidUserLoginException();
	}
	
	//ADMIN, TRAINEE, MOD
	@GetMapping("/getallmoderator")
	//@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<User> getAllModerator() {

		LOG.info("data");	
		return mi.getAllModerator();
		    
		
	}

}
