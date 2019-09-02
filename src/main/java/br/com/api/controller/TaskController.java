package br.com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.service.TaskService;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService service;
	
	@GetMapping(value = { "/getAll", "/getAll/", "/get-all/", "/get-all", "" })
	// retorna as flags true or false
	public ResponseEntity<?> getAll() {// inicio metodo
		try {// inicio try
			return ResponseEntity.ok(service.findAll()); // retur
		} // fim try
		catch (Exception e) { // init catch
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);// return erro
		} // fim cacth
	}// fim do metodo
	
}
