package br.com.api.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.Task;
import br.com.api.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService service;
	
	@GetMapping(path = { "/getAll" })
	public ResponseEntity<?> getAll() {
		try {// inicio try
			return ResponseEntity.ok(service.findAll()); 
		} // fim try
		catch (Exception e) { 
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} 
	}
	
	@PostMapping()
	public ResponseEntity<?> save(HttpServletRequest request,@RequestBody Task dto){
		try {
			
			Task responseEntity = service.save(dto);
			return ResponseEntity.ok(responseEntity);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = { "/{id}", "/{id}/" })
	public ResponseEntity<?> getById(@PathVariable("id") String id){
		try {
			Optional<Task> task = service.findById(id);
			if(task.isPresent()) {
			return ResponseEntity.ok(task.get());
			}
			else {
				return new ResponseEntity<String>("Id not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = {"/{id}", "/{id}/"})
	public ResponseEntity<?> deleteById(HttpServletRequest request, @PathVariable("id") String id){
		try {
		
			Optional<Task> responseEntity = service.findById(id);

			if(service.deleteById(id)) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<String>("This axis can not be deleted", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = {"/{id}", "/{id}/"})
	public ResponseEntity<?> updateById(HttpServletRequest request, @PathVariable("id") String id, @RequestBody Task dto){
		try {
			
			Task responseEntity = service.updateTask(id, dto);
			
			return ResponseEntity.ok(responseEntity);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
