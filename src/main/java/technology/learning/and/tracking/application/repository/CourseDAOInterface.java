package technology.learning.and.tracking.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import technology.learning.and.tracking.application.model.CourseEntity;
@Repository
public interface CourseDAOInterface extends JpaRepository <CourseEntity, Long> {
	
	public abstract CourseEntity findCourseByCid(int cid);

	public abstract List<CourseEntity> findCourseByCname(String cname);
	
	public abstract void deleteByCid(int cid);
	
}