package it.springboot.springbootexample;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.springboot.springbootexample.model.Prodotto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


//@SpringBootTest > se lo lascia, carica tutto l'applicationcontext, a noi non serve
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // test solo su db
class SpringBootExampleApplicationTests {
	// quando faccio i test, le modifiche non avranno commit sul mio database
	
	//gestisce la persistenza al database, quello che in teoria faremo
	//con repository
	@Autowired
	private EntityManager entityManager;
	
	@Test
	void persistObjectProduct() {
		//entityManager.find(null, entityManager)
		//entityManager.merge(null)
		// restituisce errore > non possiamo usare linguaggio nativo
		//TypedQuery q = entityManager.createQuery("SELECT * from prodotti", Prodotto.class);
		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);
		Prodotto p = new Prodotto();
		p.setNome("Maglia");
		p.setDescrizione("Cotone");
		p.setPrezzo(30F);
		List<Prodotto> allBeforePersist = q.getResultList();
		Assertions.assertThat(allBeforePersist).hasSize(4);
		entityManager.persist(p);
		List<Prodotto> allAterPersist = q.getResultList();
		Assertions.assertThat(allAterPersist).hasSize(5);
		
	}

	@Test
	void updateObjectProdotto() {
		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

		List<Prodotto> all = q.getResultList();

		Prodotto p = all.get(0);

		String n = "nuovo nome";
		String d = "nuova descrizione";
		p.setNome(n);
		p.setDescrizione(d);

		entityManager.persist(p);

		List<Prodotto> allAfterPersist = q.getResultList();
		
		p = allAfterPersist.get(0);

		Assertions.assertThat(p).extracting("nome").isEqualTo(n);
		Assertions.assertThat(p).extracting("descrizione").isEqualTo(d);

	}

	
}
