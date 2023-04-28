package it.test.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.test.test.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestApplicationTests {

// Aggiungere dei test con AssertJ nell’esempio JPA:
//controllare se il metodo remove dell’entityManager elimina una riga
//controllare il totale delle righe
//controllare se inserendo una nuova riga, tutti i campi della riga sono inseriti correttamente
//con il metodo extraction

	
	@Autowired
	private EntityManager entityManager;

	@Test
	void removeObjectBook() {
		TypedQuery<Book> q = entityManager.createQuery("DELETE from Book where b.id = ?", Book.class);
		Book b = entityManager.
	}
	
}
