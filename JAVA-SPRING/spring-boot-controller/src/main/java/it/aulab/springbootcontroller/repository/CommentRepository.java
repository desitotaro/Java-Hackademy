package it.aulab.springbootcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.aulab.springbootcontroller.model.Comment;
/* Se è INSERT la funzione deve tornare void */
/* Se è UPDATE la funzione deve ritornare INT, quindi il numero di righe su cui ha fatto update - Entità*/
/* Se è DELETE la funzione deve ritornare INT, quindi il numero di righe eliminate */
public interface CommentRepository extends JpaRepository<Comment, Long>{
    @Modifying
    @Query("DELETE FROM Comment c WHERE c.email LIKE 'desi'")
    void deleteDesiree();
}
