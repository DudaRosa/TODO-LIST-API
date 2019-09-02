package br.com.api.config;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootApplication
@Configuration
public class ApplicationConfig {

	@Bean
	// confgire mvc
	public WebMvcConfigurer corsConfigurer() { // inicio metodo
		// instance WebMvcConfigure
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
				registry.addMapping("/todo**");
				registry.addMapping("/todo/**");
			}// fim add cors
		};
	}// fim do metodo

	public static void main(String[] args) { // inicio metodo
		
		System.setProperty("server.servlet.context-path", "/todo");
		System.setProperty("server.servlet.contextPath", "/todo");
		System.setProperty("server.contextPath", "/todo");

		System.setProperty("management.endpoints.web.exposure.include", "*");

		System.setProperty("server.compression.enabled", "true");
		System.setProperty("server.compression.mime-types", "application/json,application/xml,text/html,text/xml,text/plain");
		System.setProperty("endpoints.beans.id", "springbeans");
		System.setProperty("endpoints.beans.sensitive", "false");
		System.setProperty("endpoints.beans.enabled", "true");
		
		
		SpringApplication.run(ApplicationConfig.class, args);
		
	}// fim do metodo
}
