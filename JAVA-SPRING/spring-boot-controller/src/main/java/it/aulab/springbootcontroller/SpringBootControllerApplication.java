package it.aulab.springbootcontroller;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

import it.aulab.springbootcontroller.util.mapper.AuthorToAuthorDTOPropertyMap;
import it.aulab.springbootcontroller.util.mapper.CreatePostDTOToPostPropertyMap;
import it.aulab.springbootcontroller.util.mapper.PostToPostDTOPropertyMap;

@SpringBootApplication
public class SpringBootControllerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootControllerApplication.class, args);
		
	}

	@Bean
	public SpringSecurityDialect addSpringTemplateDialect() {
		return new SpringSecurityDialect();
	}

	
	@Bean 
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper();
		CreatePostDTOToPostPropertyMap createPostDTOToPostMap = new CreatePostDTOToPostPropertyMap();
		AuthorToAuthorDTOPropertyMap authorToAuthorDTOPropertyMap = new AuthorToAuthorDTOPropertyMap();
		PostToPostDTOPropertyMap postDTOPropertyMap = new PostToPostDTOPropertyMap();
		mapper.addMappings(createPostDTOToPostMap);
		mapper.addMappings(authorToAuthorDTOPropertyMap);
		mapper.addMappings(postDTOPropertyMap);
		return mapper;
	}
	
	
	
}
