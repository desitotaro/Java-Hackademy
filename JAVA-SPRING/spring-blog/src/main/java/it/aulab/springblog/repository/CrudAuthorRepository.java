package it.aulab.springblog.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import it.aulab.springblog.model.Author;

public interface CrudAuthorRepository extends ListCrudRepository<Author, Long> {
    
    public List<Author> findByLastname(String lastname);

    public List<Author> findByFirstnameAndLastname(String a, String b);

    public List<Author> findByFirstnameOrLastname(String a, String b);

    public List<Author> findByFirstnameNotIgnoreCase(String s);

    public List<Author> findByFirstnameEquals(String s);

    public List<Author> findByFirstnameContains(String s);

}
