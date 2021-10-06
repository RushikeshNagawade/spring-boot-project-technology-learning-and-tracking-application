package technology.learning.and.tracking.application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import technology.learning.and.tracking.application.model.User;


public interface ModeratorServiceInterface {

	
    public abstract User moderatorRegisterService(User md);
	

	public abstract User findModeratorById(int id);
	
	public abstract User findModeratorByEmail(String email);

	public abstract User modUpdateService(User us, long id);

	public abstract User deleteModerator(int id);

	public abstract List<User> getAllModerator();

}
