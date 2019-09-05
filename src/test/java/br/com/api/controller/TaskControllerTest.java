package br.com.api.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.NotAcceptableStatusException;

import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import br.com.api.common.EntityMock;
import br.com.api.dto.Task;
import br.com.api.service.TaskService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TaskControllerTest {
	@Mock
	private TaskService service;

	@InjectMocks
	private TaskController controller;
	
	@Mock
	private HttpServletRequest request;

	@Mock
	private Task dtoTask;
	
	@Before
	public void beforeServiceDto() {
		dtoTask = new Task();
		dtoTask.setName("Teste");
		dtoTask.setStatus("completed");

		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void getAllTest() throws Exception {

		when(this.service.findAll()).thenReturn(null);
		assertNotNull("Sucesso", this.controller.getAll());
	}

	@Test
	public void getAllTest_exception() throws Exception {
		when(this.service.findAll()).thenThrow();
		assertNotNull("Sucesso", this.controller.getAll());
	}
	
//	---------------------------------------------------------
	
	@Test
	public void getByIdTest() throws Exception {

		when(this.service.findById("5d2600febdafc240a8f0f630")).thenReturn(dtoTask);
		assertNotNull("Sucesso", this.controller.getById("5d2600febdafc240a8f0f630"));
	}
	
	@Test
	public void getByIdNullTest() throws Exception {

		when(this.service.findById(null))
				.thenReturn(null);
		assertNotNull("Sucesso", this.controller.getById(null));
	}


	@Test
	public void getByIdTest_exception() throws Exception {
		when(this.service.findById("5d2600febdafc240a8f0f630")).thenThrow();
		assertNotNull("Sucesso", this.controller.getById("5d2600febdafc240a8f0f630"));
	}

	// --------------------------------------------------------------------------------------
	
		@Test
		public void saveTest() throws Exception {
			Task dto = new Task();
			dto = new Task();
			dto.setName("Teste");
			dto.setStatus("completed");
			
			when(this.service.save(dtoTask))
			.thenReturn(null);
			assertNotNull("Sucesso", this.controller.save(request,dto));
			
			when(this.service.save(dto))
			.thenReturn(null);
			assertNotNull("Sucesso", this.controller.save(request,dto));
		}

		@Test
		public void saveTest_exception() throws Exception {
			assertNotNull("Sucesso", this.controller.save(request, dtoTask));
		}
		
		@Test
		public void saveTest_NotAcceptableStatusException() throws NotAcceptableStatusException {
			Mockito.doThrow(NotAcceptableStatusException.class).when(service).save(dtoTask);
			assertNotNull("Sucesso", this.controller.save(request, null));
		}
		// --------------------------------------------------------------------------------------
		@Test
		public void deleteTest() throws Exception {

			when(this.service.deleteById("id")).thenReturn(true);
			assertNotNull("Sucesso", this.controller.deleteById(request, "id"));
		}
		@Test
		public void deleteNullTest() throws Exception {

			when(this.service.deleteById(null)).thenReturn(false);
			assertNotNull("Sucesso", this.controller.deleteById(request, null));
		}

		@Test
		public void deleteTest_exception() throws Exception {
			when(this.service.deleteById("id")).thenThrow();
			assertNotNull("Sucesso", this.controller.deleteById(request, "id"));
		}
		// --------------------------------------------------------------------------------------
		@Test
		public void putTagTest() throws Exception {
			Task dto = new Task();
			dto = new Task();
			dto.setName("Teste");
			dto.setId("id");
			dto.setStatus("completed");
			
			when(this.service.updateTask("id", dto)).thenReturn(null);
			assertNotNull("Sucesso", this.controller.updateById(request,"id", dto));
		}

		@Test
		public void putTagTest_exception() throws Exception {
			when(this.service.updateTask("id", dtoTask)).thenThrow();
			assertNotNull("Sucesso", this.controller.updateById(request,"id", dtoTask));
		}
}
