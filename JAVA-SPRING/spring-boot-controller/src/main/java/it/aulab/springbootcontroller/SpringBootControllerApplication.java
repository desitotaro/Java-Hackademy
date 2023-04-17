package it.aulab.springbootcontroller;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.aulab.springbootcontroller.util.mapper.AuthorToAuthorDTOPropertyMap;
import it.aulab.springbootcontroller.util.mapper.CreatePostDTOToPostPropertyMap;

@SpringBootApplication
public class SpringBootControllerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootControllerApplication.class, args);
		
	}
	
	@Bean 
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper();
		CreatePostDTOToPostPropertyMap createPostDTOToPostMap = new CreatePostDTOToPostPropertyMap();
		AuthorToAuthorDTOPropertyMap authorToAuthorDTOPropertyMap = new AuthorToAuthorDTOPropertyMap();
		mapper.addMappings(createPostDTOToPostMap);
		mapper.addMappings(authorToAuthorDTOPropertyMap);
		return mapper;
	}
	
	
	
}
