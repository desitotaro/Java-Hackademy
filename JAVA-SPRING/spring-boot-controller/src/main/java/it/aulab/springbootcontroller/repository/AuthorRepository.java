package it.aulab.springbootcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springbootcontroller.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
    
    public List<Author> findByFirstname(String firstname);
    
    public List<Author> findByLastname(String lastname);

    public List<Author> findByFirstnameAndLastname(String a, String b);

    public List<Author> findByFirstnameOrLastname(String a, String b);

    public List<Author> findByFirstnameNotIgnoreCase(String s);

    public List<Author> findByFirstnameEquals(String s);

    public List<Author> findByFirstnameContains(String s);

}
