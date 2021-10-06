package technology.learning.and.tracking.application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import technology.learning.and.tracking.application.model.CourseEntity;


public interface CourseServiceInterface {

	
    public abstract CourseEntity courseRegisterService(CourseEntity cr);


    public abstract CourseEntity findCourseByCid(int cid);


     public abstract List<CourseEntity> findCourseByCname(String cname);


     public abstract CourseEntity courseUpdateService(CourseEntity cs, int cid);


     public abstract CourseEntity deleteCourse(int cid);


     public abstract List<CourseEntity> getAllCourses();

}