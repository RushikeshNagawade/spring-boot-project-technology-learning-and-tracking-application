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

import technology.learning.and.tracking.application.model.TraineeEntity;
import technology.learning.and.tracking.application.repository.TraineeDAOInterface;
import technology.learning.and.tracking.application.service.TraineeService;

@SpringBootTest
public class TraineeControllerTest {

	@InjectMocks
	private TraineeService traineeService;
	
	@Mock
	private TraineeDAOInterface traineeDAOInterface;
	
//	@Test
//	public void  usercreate() {
//		
//	TraineeEntity trainee = new TraineeEntity(301,"lying","panda","completed");
//	Mockito.when(traineeDAOInterface.save(trainee)).thenReturn(trainee);	
//	TraineeEntity traineeActual1 =traineeService.userRegisterService(trainee);		
//		assertEquals( trainee.getTid(), traineeActual1.getTid());
//	}
//	
//	@Test
//	public void usersearch() {
//		TraineeEntity trainee = new TraineeEntity(301,"lying","panda","panda@gmail.com","completed");
//		Mockito.when(traineeDAOInterface.save(trainee)).thenReturn(trainee);	
//		TraineeEntity traineeActual1 =traineeService.userRegisterService(trainee);		
//			assertEquals( trainee.getTid(), traineeActual1.getTid());
//		
//	}
//	
//	@Test
//	public void updateuser() {
//		TraineeEntity trainee = new TraineeEntity(301,"lying","panda","panda@gmail.com","completed");
//		Mockito.when(traineeDAOInterface.save(trainee)).thenReturn(trainee);	
//		TraineeEntity traineeActual1 =traineeService.userUpdateService(trainee);		
//			assertEquals( trainee.getTid(), traineeActual1.getTid());
//		
//	}
//	
//	@Test
//	public void deleteuserbyemail() throws Exception {
//		TraineeEntity course = new TraineeEntity(301,"lying","panda","panda@gmail.com","completed");	
//		traineeDAOInterface.deleteByTemail(course.getTemail());
//		verify(traineeDAOInterface, times(1)).deleteByTemail(course.getTemail());
//		
//	}
//	
//	@Test
//	public void findTraineeByTid() {
//		TraineeEntity trainee = new TraineeEntity(301,"lying","panda","panda@gmail.com","completed");
//		Mockito.when(traineeDAOInterface.save(trainee)).thenReturn(trainee);	
//		TraineeEntity traineeActual1 =traineeService.userUpdateService(trainee);		
//			assertEquals( trainee.getTid(), traineeActual1.getTid());
//		
//	}
//	
//	@Test
//	public void deleteuser() throws Exception{
//		
//		TraineeEntity course = new TraineeEntity(301,"lying","panda","panda@gmail.com","completed");	
//		traineeDAOInterface.deleteByTid(course.getTid());
//		verify(traineeDAOInterface, times(1)).deleteByTid(course.getTid());
//	}
//
//	@Test
//	public void getalltrainees() {
//		TraineeEntity trainee1 = new TraineeEntity(301,	"lying",	"panda",	"panda@gmail.com","completed");
//		TraineeEntity trainee2 = new TraineeEntity(302,	"flying",	"horse",	"horse@gmail.com","pending");
//		TraineeEntity trainee3 = new TraineeEntity(303,	"eating",	"mantis",	"mantis@gmail.com","pending");
//		
//	
//		List<TraineeEntity> traineelist = new ArrayList<>();
//		traineelist.add(trainee1);
//		traineelist.add(trainee2);
//		traineelist.add(trainee3);
//		
//		
//		Mockito.when(traineeDAOInterface.findAll()).thenReturn(traineelist);
//		 List<TraineeEntity> actualTraineeList = traineeService.getAllTrainees();
//		assertEquals( traineelist.size(), actualTraineeList.size());
//		verify(traineeDAOInterface,times(1)).findAll();
//	
//	}
//	
//	@Test
//	public void usersearchstatus() {
//		TraineeEntity trainee = new TraineeEntity(301,"lying","panda","panda@gmail.com","completed");
//		Mockito.when(traineeDAOInterface.save(trainee)).thenReturn(trainee);	
//		TraineeEntity traineeActual1 =traineeService.userUpdateService(trainee);		
//			assertEquals( trainee.getTid(), traineeActual1.getTid());
//		
//	}
}
