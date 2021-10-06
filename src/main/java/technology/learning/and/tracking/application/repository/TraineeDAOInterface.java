package technology.learning.and.tracking.application.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.TraineeEntity;

@Repository
public interface TraineeDAOInterface extends JpaRepository <TraineeEntity, Integer> {
	

	public abstract List<TraineeEntity> findTraineeByStatus(String status);

	@Modifying
	@Transactional
	@Query("update technology.learning.and.tracking.application.model.TraineeEntity SET status =:status where user_id=:id")
	public int updateStatus(String status,int id);	

	public abstract TraineeEntity findTraineeByTid(int tid);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO trainee_course (tid, cid) VALUES (?1, ?2)", nativeQuery = true)
	public abstract void applyForCourse(int tid, int cid);
	
	public abstract void deleteByTid(int tid);

	}