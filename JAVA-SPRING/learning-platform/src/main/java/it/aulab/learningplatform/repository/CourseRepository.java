package it.aulab.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
