package it.aulab.springbootcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.aulab.springbootcontroller.model.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
    @Query("SELECT p FROM Post p WHERE p.author.firstname = 'Desiree'")
    List<Post> findDesiree();
    @Query("SELECT p from Post p WHERE p.author.firstname = ?1")
    List<Post> findByAuthorFirstname(String firstname);
    /* In base ai parametri che passo, queste sono due varianti, in base alle specifiche del nostro software */
    /* @Query("SELECT p from Post p WHERE p.author.firstname = :firstname")
    List<Post> findByAuthorFirstname(@Param("firstname")String firstname); */

    @Query("SELECT p FROM Post p WHERE p.author.firstname = :firstname AND p.author.lastname = :lastname")
    List<Post> findByAuthorFirstnameAndLastname(@Param("lastname") String lastname,
            @Param("firstname") String firstname);


}
