package it.aulab.finalproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.aulab.finalproject.util.mapping.CourseToCourseDtoPropertyMap;
import it.aulab.finalproject.util.mapping.CreateCourseDtoToCoursePropertyMap;
import it.aulab.finalproject.util.mapping.LessonDtoToLessonPropertyMap;

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Bean
	public ModelMapper instanceModelMapper(){
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new CreateCourseDtoToCoursePropertyMap());
		mapper.addMappings(new CourseToCourseDtoPropertyMap());
		mapper.addMappings(new LessonDtoToLessonPropertyMap());
		return mapper;
	}
}
