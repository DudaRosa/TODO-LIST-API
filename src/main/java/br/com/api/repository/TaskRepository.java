package br.com.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.api.dto.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

	
	
}