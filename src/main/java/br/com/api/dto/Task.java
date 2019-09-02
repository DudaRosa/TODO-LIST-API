package br.com.api.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "task")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	
	@Field("status")
	private String status;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}
