package br.com.api.dto;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaskTest {
	@InjectMocks
	private Task taskModel;

	//initialization of variable to test
	@Before
	public void beforeService() {
	
		this.taskModel.setId("5b7b0ccaa2d9eb001ec6e01a");
				
		this.taskModel.setName("Seguros Viagem");
	
		this.taskModel.setStatus("pending");
		
		
	}

	//Test if getters return null 
	@Test
	public void testIsEmpty() {
		assertNotNull(this.taskModel.getId());
		assertNotNull(this.taskModel.getName());
		assertNotNull(this.taskModel.getStatus());
	}	
}
