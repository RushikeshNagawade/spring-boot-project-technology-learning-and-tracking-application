package technology.learning.and.tracking.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import technology.learning.and.tracking.application.model.EventEntity;

@Repository
public interface EventDAOInterface extends JpaRepository <EventEntity, Long>{

	public abstract ResponseEntity<EventEntity> findEventByEid(int eid);

	public abstract void deleteByEid(int eid);

}
