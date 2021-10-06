package technology.learning.and.tracking.application.service;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired(required=true);
import org.springframework.stereotype.Service;

import technology.learning.and.tracking.application.service.CourseServiceInterface;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.User;
import technology.learning.and.tracking.application.repository.CourseDAOInterface;

@Service
public class CourseService implements CourseServiceInterface {
		
	private static final Logger LOG = LoggerFactory.getLogger(CourseService.class);

	    @Autowired
		private CourseDAOInterface ci;
		
	    public boolean isLoggedIn = false;
	    
	    
		@Override
		public CourseEntity courseRegisterService(CourseEntity cr) {
			LOG.info("course register");
				return ci.save(cr);
			}
		
		
		@Override
		public CourseEntity findCourseByCid(int cid) {
			LOG.info("course search by id");
			return ci.findCourseByCid(cid);
		}
		
		@Override
		public List<CourseEntity> findCourseByCname(String cname) {
			LOG.info("course search by name");
			return ci.findCourseByCname(cname);
		}
		//admin and moderator
		 @Override
		  public CourseEntity courseUpdateService(CourseEntity cs, int cid) {
				LOG.info("updateCourse");
				return ci.save(cs);
			}
		 
		 //admin and moderator
		 @Override
		 public CourseEntity deleteCourse(int cid) {
			 LOG.warn("deleteCourse");
			 ci.deleteByCid(cid);
			 return null;
		 }
		 
		 //all
		 @Override
		 public List<CourseEntity> getAllCourses() {
//				LOG.info("getAllCourses");
//				return  ci.findAll();
			     List<CourseEntity> list=new ArrayList<>();
				ci.findAll().forEach(list1->list.add(list1));
				return list;
			}
}