package br.com.api.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import br.com.api.dto.Task;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

	@InjectMocks
	private TaskService service;
	
	@Mock
	private MongoTemplate mongoTemplate;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void findAllTest() {
		Mockito.when(service.findAll()).thenReturn(new ArrayList());
		assertNotNull(service.findAll());
	}
	
//----------------------------------------------------------------------------------
	
	
	@Test
	public void saveTest() {
		Task dto = new Task();
		dto = new Task();
		dto.setName("Teste");
		dto.setStatus("completed");
		
		Mockito.when(service.save(dto)).thenReturn(dto);
		assertNotNull(service.save(dto));
	}
	
//----------------------------------------------------------------------------------
	
		@Test
		public void findByIdTest() {
			Task dto = new Task();
			dto = new Task();
			dto.setName("Teste");
			dto.setStatus("completed");
			
			Mockito.when(service.findById("id")).thenReturn(dto);
			assertNotNull(service.findById("id"));
		}
		
	//----------------------------------------------------------------------------------
		
			@Test
			public void deleteByIdTest() {
				
				Mockito.when(service.deleteById("5d2600febdafc240a8f0f630")).thenReturn(null);
				assertNotNull(service.deleteById("5d2600febdafc240a8f0f630"));
			}
			

			@Test
			public void deleteByIdNullTest() {
				
				Mockito.when(service.deleteById(null)).thenReturn(null);
				assertNotNull(service.deleteById(null));
			}
			//----------------------------------------------------------------------------------
			
			
			@Test
			public void updateNullTest() {
				Task dto = new Task();
				dto = new Task();
				dto.setId(null);
				dto.setName(null);
				dto.setStatus(null);
				
				Mockito.when(service.updateTask("id",dto)).thenReturn(dto);
				assertNotNull(service.updateTask("id", dto));
			}
			
			
			@Test
			public void updateTest() {
				Task dto = new Task();
				dto = new Task();
				dto.setId("teste");
				dto.setName("teste");
				dto.setStatus("teste");
				
				Mockito.when(service.findById("id")).thenReturn(dto);
				Mockito.when(service.updateTask("id",dto)).thenReturn(null);

			}
			
}
