package br.com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.api.dto.Task;

@Service
public class TaskService {
	
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
	
	public Task save(Task entity) {
		entity.setId(null);
		return mongoTemplate.save(entity);
	}
	
	public Task findById(String id) {
		return mongoTemplate.findById(id, Task.class);
	}
	
	public boolean deleteById(String id) {
	
		if(id != null) {
			mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Task.class);
			return true;
		}
		return false;
	}
	
	public Task updateTask(String id, Task entity) {
		Task task = this.findById(id);
		
		if(entity.getName() != null)
			task.setName(entity.getName());
		
		if(entity.getStatus() != null)
			task.setStatus(entity.getStatus());
		
		return mongoTemplate.save(task);
	}
}
