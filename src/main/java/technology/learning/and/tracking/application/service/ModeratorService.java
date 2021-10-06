package technology.learning.and.tracking.application.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired(required=true);
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import technology.learning.and.tracking.application.model.User;
import technology.learning.and.tracking.application.repository.ModeratorDAOInterface;

@Service
public class ModeratorService implements ModeratorServiceInterface {

	private static final Logger LOG = LoggerFactory.getLogger(ModeratorService.class);

	@Autowired
	private ModeratorDAOInterface mi;

	public boolean isLoggedIn = false;

	@Override
	public User moderatorRegisterService(User md) {
		return mi.save(md);
	}


	@Override
	public User findModeratorById(int id) {
		LOG.info("moderator search");
		//return mi.findModeratorById(id).orElse(null);
		return mi.findModeratorById(id);
	}
	
	@Override
	public User findModeratorByEmail(String email) {
		LOG.info("moderator search");
		return mi.findModeratorByEmail(email);
	}
	
	
	//admin and moderator
		@Override
		  public User modUpdateService(User us, long id) {
				LOG.info("updateUser");
				return mi.save(us);
			}
		
		//admin
		@Override
		  public User deleteModerator(int id) {
				LOG.info("deleteModerator");
				mi.deleteModeratorById(id);
				return null;
			}
		
		//admin
		@Override
		 public List<User> getAllModerator() {

				List<User> list=new ArrayList<>();
				mi.findAll().forEach(list1->list.add(list1));
				return list;
			}

	
}