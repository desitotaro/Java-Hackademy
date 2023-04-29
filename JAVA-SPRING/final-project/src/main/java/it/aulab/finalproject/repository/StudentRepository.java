package it.aulab.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.finalproject.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByFirstname(String firstname);
    List<Student> findByLastname(String lastname);
    List<Student> findByFirstnameAndLastname(String firstname, String lastname);
}
