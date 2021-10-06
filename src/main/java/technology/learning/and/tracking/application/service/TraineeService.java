package technology.learning.and.tracking.application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import technology.learning.and.tracking.application.Exception.CourseNotFoundException;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.TraineeEntity;
import technology.learning.and.tracking.application.repository.TraineeDAOInterface;

@Service
public class TraineeService implements TraineeServiceInterface{


	private static final Logger LOG = LoggerFactory.getLogger(TraineeService.class);
	
	 @Autowired
		private TraineeDAOInterface ui;
	    
	    //all
	    @Override
		public TraineeEntity userRegisterService(TraineeEntity us) {
				//return ui.save(us);
				TraineeEntity a = ui.save(us);
				
				if(a == null) {
					 new Exception("Can not create :: ");
				}
				
				return a ;
			}
	    
	    //all
	 
	  
	  //all
	   // @Query("SELECT t FROM trainee t WHERE LOWER(p.lastName) = LOWER(:lastName)")
	  @Override
	  public TraineeEntity userUpdateService(TraineeEntity us, int tid) {
			LOG.info("updateUser");
			return ui.save(us);
		}
	  
	  
	  
	  @Override
		public TraineeEntity ApproveStatusService(String status,int id) {
			int i=ui.updateStatus(status,id);
			TraineeEntity l=null;
				if(i>0) {
					l = new TraineeEntity();
					l.setTid(id);
					//l.setPassword("asdsd");
					l.setStatus(status);
					//l.setUser(getUser());
				
				}
				return l;
			}
	  
	  @Override
	  public TraineeEntity findTraineeByTid(int tid) {
			LOG.info("trainee search by id");
			return ui.findTraineeByTid(tid);
		}
	  
	  //admin and moderator
	@Override
	public int deleteTrainee(int tid) {
		LOG.info("deleteTrainee");
		ui.deleteByTid(tid);
		return tid;
	}
	
	//admin and moderator
	@Override
	public List<TraineeEntity> getAllTrainees() {
		LOG.info("getAllTraineesSuccess");
		return ui.findAll();
	}

	@Override
	public List<TraineeEntity> usersearchbystatusService(String status) {
		LOG.info("userSearchSuccess");
		return ui.findTraineeByStatus(status);
	}
		
	public String applyForCourse(int tid) {
		
		ui.applyForCourse(1, tid); 
		return "Applied successfully";
	}
}