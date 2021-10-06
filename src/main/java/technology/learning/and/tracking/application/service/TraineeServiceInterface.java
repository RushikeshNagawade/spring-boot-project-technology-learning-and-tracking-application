package technology.learning.and.tracking.application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.TraineeEntity;

public interface TraineeServiceInterface {

public abstract TraineeEntity userRegisterService(TraineeEntity us);
    

	public abstract List<TraineeEntity> usersearchbystatusService(String status);
	
	public abstract TraineeEntity userUpdateService(TraineeEntity us, int tid);


	public abstract TraineeEntity findTraineeByTid(int tid);

	public abstract int deleteTrainee(int tid);

	public abstract List<TraineeEntity> getAllTrainees();
	
	 
	
	public abstract String applyForCourse(int tid);

	TraineeEntity ApproveStatusService(String status, int id);
	
}
