package br.com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;
import br.com.api.model.Task;
import br.com.api.repository.TaskRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Collation;

@Component
public class TaskService {

	@Autowired
	private TaskRepository repository; 
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Task> findAll() {
		
		Query query = new Query();
		
		query.with(new Sort(Sort.Direction.ASC,"name"));
		
		// Faz com que as letras maiúsculas e minúsculas sejam tradas como iguais
		query.collation(Collation.of("en").strength(Collation.ComparisonLevel.secondary()));
		
		List<Task> listTask = mongoTemplate.find(query,Task.class);
		
		
		return listTask;
	}
}
