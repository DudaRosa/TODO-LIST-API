package br.com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.api.dto.Task;
import br.com.api.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired(required=false)
	private TaskRepository taskRepository; 
	
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
	
	public Optional<Task> findById(String id) {
		return taskRepository.findById(id);
	}
	
	public boolean deleteById(String id) {
		
		if(id != null) {
			taskRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Task updateTask(String id, Task entity) {
		Optional<Task> atualizada = this.findById(id);
		
		if(entity.getName() != null)
			atualizada.get().setName(entity.getName());
		
		if(entity.getStatus() != null)
			atualizada.get().setStatus(entity.getStatus());
		
		return taskRepository.save(atualizada.get());
	}
}
