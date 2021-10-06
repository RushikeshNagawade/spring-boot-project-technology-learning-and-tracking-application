package technology.learning.and.tracking.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.repository.CourseDAOInterface;
import technology.learning.and.tracking.application.service.CourseService;


@SpringBootTest
public class CourseControllerTest {
}
//	@InjectMocks
//	private CourseService courseService ;
//	
//	@Mock
//	private CourseDAOInterface courseDAOInterface;
//	
//	@Test
//	public void coursecreate() {
		
//	CourseEntity course = new CourseEntity(401,"java","full java course with xyz", 499.99);
//	Mockito.when(courseDAOInterface.save(course)).thenReturn(course);	
//	CourseEntity courseActual1 = courseService.courseRegisterService(course);		
//		assertEquals( course.getCid(), courseActual1.getCid());
//	}
//	
//	@Test
//	public void findCourseByCid() {
//		
//	CourseEntity course = new CourseEntity(401,"java","full java course with xyz", 499.99);
//	Mockito.when(courseDAOInterface.save(course)).thenReturn(course);	
//	CourseEntity courseActual1 = courseService.courseRegisterService(course);		
//		assertEquals( course.getCid(), courseActual1.getCid());
//	}
//	
//	@Test
//	public void findCourseByCname() {
//		
//	CourseEntity course = new CourseEntity(401,"java","full java course with xyz", 499.99);
//	Mockito.when(courseDAOInterface.save(course)).thenReturn(course);	
//	CourseEntity courseActual1 = courseService.courseRegisterService(course);		
//		assertEquals( course.getCname(), courseActual1.getCname());
//	}
//	
//	@Test
//	public void updatecourse() {
//		
//	CourseEntity course = new CourseEntity(401,"java","full java course with xyz", 499.99);
//	Mockito.when(courseDAOInterface.save(course)).thenReturn(course);	
//	CourseEntity courseActual1 = courseService.courseUpdateService(course, 401);		
//		assertEquals( course.getCid(), courseActual1.getCid());
//	}
//	
//	@Test
//	public void deletecourse() throws Exception{
//		
//		CourseEntity course = new CourseEntity(401,"java","full java course with xyz", 499.99);	
//		courseDAOInterface.deleteByCid(course.getCid());
//		verify(courseDAOInterface, times(1)).deleteByCid(course.getCid());
//	}
	
//	@Test
//	public void getAllCourses() { 
//		
//		CourseEntity course = new CourseEntity(401,"java","full python course with xyz", 499.99);	
//		CourseEntity course1 = new CourseEntity(402,"python","full python course with xyz", 999.99);	
//		CourseEntity course2 = new CourseEntity(403,"c","full python course with xyz", 599.99);	
//		
//		List<CourseEntity> courselist = new ArrayList<>();
//		courselist.add(course);
//		courselist.add(course1);
//		courselist.add(course2);
//		
//		Mockito.when(courseDAOInterface.findAll()).thenReturn(courselist);
//		ResponseEntity<List<CourseEntity>> actualCourseList = courseService.getAllCourses();
//		assertEquals( courselist.size(), ((List<CourseEntity>) actualCourseList).size());
//		verify(courseDAOInterface,times(1)).findAll();
//	}
