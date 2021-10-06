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
import technology.learning.and.tracking.application.model.User;
import technology.learning.and.tracking.application.repository.ModeratorDAOInterface;
import technology.learning.and.tracking.application.service.ModeratorService;

@SpringBootTest
public class ModeratorControllerTest {

	@InjectMocks
	private ModeratorService moderatorService;
	
	@Mock
	private ModeratorDAOInterface moderatorDAOInterface;
	
	@Test
	public void moderatorcreate() {
		
	User md = new User("sonu","sonu@gmail.com","123456");
	Mockito.when(moderatorDAOInterface.save(md)).thenReturn(md);	
	User mdActual1 = moderatorService.moderatorRegisterService(md);		
		assertEquals( md.getId(), mdActual1.getId());
	}
	
	@Test
	public void findModeratorByMid() {
		
	User md = new User("sonu","sonu@gmail.com","123456");
	Mockito.when(moderatorDAOInterface.save(md)).thenReturn(md);	
	User mdActual1 = moderatorService.moderatorRegisterService(md);		
		assertEquals( md.getId(), mdActual1.getId());
	}
	
	@Test
	public void updatemoderator() {
		
	User md = new User("sonu","sonu@gmail.com","123456");
	Mockito.when(moderatorDAOInterface.save(md)).thenReturn(md);	
	User mdActual1 = moderatorService.moderatorRegisterService(md);		
		assertEquals( md.getId(), mdActual1.getId());
	}



	@Test
	public void deletemoderator() throws Exception{
		
		User md = new User("sonu","sonu@gmail.com","123456");	
		moderatorDAOInterface.deleteModeratorById(md.getId());
		verify(moderatorDAOInterface, times(1)).deleteModeratorById(md.getId());
	}
	
	@Test
	public void getAllModerator() { 
		
		User md = new User("sonu","sonu@gmail.com","123456");	
		User md2 = new User("monu","monu@gmail.com","123456");
		
		List<User> modlist = new ArrayList<>();
		modlist.add(md);
		modlist.add(md2);
		
		Mockito.when(moderatorDAOInterface.findAll()).thenReturn(modlist);
		List<User> actualModeratorList = moderatorService.getAllModerator();
		assertEquals( modlist.size(), actualModeratorList.size());
		verify(moderatorDAOInterface,times(1)).findAll();
	}
			
}