package br.com.api.config;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages="br.com.api")
public class ApplicationConfig {

	public static void main(String[] args) { // inicio metodo
		System.setProperty("server.servlet.context-path", "/api");
		System.setProperty("server.servlet.contextPath", "/api");
		System.setProperty("server.contextPath", "/api");

		System.setProperty("management.endpoints.web.exposure.include", "*");
		System.setProperty("server.compression.enabled", "true");
		System.setProperty("server.compression.mime-types", "application/json,application/xml,text/html,text/xml,text/plain");
		System.setProperty("endpoints.beans.id", "springbeans");
		System.setProperty("endpoints.beans.sensitive", "false");
		System.setProperty("endpoints.beans.enabled", "true");
		
		
		SpringApplication.run(ApplicationConfig.class, args);
		
	}// fim do metodo
}
