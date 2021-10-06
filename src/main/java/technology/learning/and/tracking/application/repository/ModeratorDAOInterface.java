package technology.learning.and.tracking.application.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import technology.learning.and.tracking.application.model.User;

@Repository
public interface ModeratorDAOInterface extends JpaRepository <User,Long> {
	


	public abstract User findModeratorById(int id);
	public abstract User findModeratorByEmail(String email);
	public abstract void deleteModeratorById(long id);
}