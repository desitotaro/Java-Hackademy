package it.aulab.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
    List<Course> findByNameContaining(String name);
    List<Course> findByTeacherFirstnameContaining(String teacherFirstname);
    List<Course> findByNameContainingAndTeacherFirstnameContaining(String name, String teacherFirstname);
    List<Course> findByTeacherLastnameContaining(String teacherFirstname);
    List<Course> findByNameContainingAndTeacherLastnameContaining(String name, String teacherFirstname);
    List<Course> findByTeacherFirstnameContainingAndTeacherLastnameContaining(String firstname, String teacherFirstname);
    List<Course> findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(String name, String firstname, String teacherFirstname);

}
