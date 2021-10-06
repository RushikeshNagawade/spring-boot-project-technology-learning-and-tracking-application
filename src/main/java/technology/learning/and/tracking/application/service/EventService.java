package technology.learning.and.tracking.application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.EventEntity;
import technology.learning.and.tracking.application.repository.EventDAOInterface;

@Service
public class EventService implements EventServiceInterface{

	private static final Logger LOG = LoggerFactory.getLogger(EventService.class);

	 @Autowired
		private EventDAOInterface ei;
		
	    public boolean isLoggedIn = false;
	@Override
	public EventEntity EventRegisterService(EventEntity ev) {
		LOG.info("event register");
		return ei.save(ev);
	}
	
	@Override
	public ResponseEntity<EventEntity> findEventByEid(int eid) {
		LOG.info("event search by id");
		return ei.findEventByEid(eid);
	}
	
	//admin and moderator
	 @Override
	  public EventEntity eventUpdateService(EventEntity ev) {
			LOG.info("updateEvent");
			return ei.save(ev);
		}
	 
	//admin and moderator
	 @Override
	 public int deleteEvent(int eid) {
		 LOG.warn("deleteEvent");
		 ei.deleteByEid(eid);
		 return eid;
	 }
	 
	//all
	 @Override
	 public ResponseEntity<List<EventEntity>> getAllEvents() {
			LOG.info("getAllEvents");
			return (ResponseEntity<List<EventEntity>>) ei.findAll();
		}

//	@Override
//	public List<EventEntity> getAllEvents() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<EventEntity> getAllEvent() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
