package it.demo.springweb;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.demo.springweb.model.Fornitore;
import it.demo.springweb.model.Prodotto;
import it.demo.springweb.model.Variante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
class SpringWebApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	void checkPrezzoNetto() {
		Prodotto p = new Prodotto();
		p.setNome("Maglia Nike");
		p.setDescrizione("Maglia in cotone");
		p.setPrezzo(30F);
		p.setPrezzoNetto(20F);
		entityManager.persist(p);
		
		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p where id = 1", Prodotto.class);
		//List<Prodotto> allAterPersist = q.getResultList(); 
		Prodotto queryP = q.getSingleResult(); //get result ci restituisce tutto, se sappiamo che è solo un valore usiamo questo
		Assertions.assertThat(queryP).extracting("prezzoNetto").isEqualTo(20F);
	}

	@Test
	void checkManyToOneRelation(){
		//Facciamo due typedQuery, la prima prenderà Prodotto, la seconnda Variante
		TypedQuery<Prodotto> q1 = entityManager.createQuery("SELECT p FROM Prodotto p where p.id = 1", Prodotto.class);
		Prodotto p = q1.getSingleResult(); 
		
		TypedQuery<Variante> q2 = entityManager.createQuery("SELECT v FROM Variante v where v.id = 1", Variante.class);
		Variante v = q2.getSingleResult(); 
		Assertions.assertThat(v).extracting("prodotto").isEqualTo(p);
	}

	@Test
	void checkOneToManyRelation(){
		TypedQuery<Prodotto> q1 = entityManager.createQuery("SELECT p FROM Prodotto p where p.id = 1", Prodotto.class);
		Prodotto p = q1.getSingleResult(); 
		
		Assertions.assertThat(p).extracting("varianti").asList().hasSize(4);
	}

	@Test 
	void checkProdottifromFornitori(){
		TypedQuery<Fornitore> q = entityManager.createQuery("SELECT f FROM Fornitore f", Fornitore.class);
		List<Fornitore> all = q.getResultList();

		Assertions.assertThat(all.get(0)).extracting("prodotti").asList().hasSize(1);
		Assertions.assertThat(all.get(1)).extracting("prodotti").asList().hasSize(4);
		Assertions.assertThat(all.get(2)).extracting("prodotti").asList().hasSize(2);
	}

	@Test 
	void checkFornitorifromProdotti(){
		String sql = "SELECT p FROM Prodotto p where id = ";
		TypedQuery<Prodotto> q1 = entityManager.createQuery(sql + "1", Prodotto.class);
		Prodotto p1 = q1.getSingleResult();
		Assertions.assertThat(p1).extracting("fornitori").asList().hasSize(2);

		TypedQuery<Prodotto> q2 = entityManager.createQuery(sql + "4", Prodotto.class);
		Prodotto p4 = q2.getSingleResult();
		Assertions.assertThat(p4).extracting("fornitori").asList().hasSize(1);
	}

	@Test
	void checkRelationInsert(){
		TypedQuery<Prodotto> q1 = entityManager.createQuery("SELECT p FROM Prodotto p where p.id = 1", Prodotto.class);
		Prodotto p = q1.getSingleResult(); 

		Variante newVariant = new Variante();
		newVariant.setAttributo("Taglia");
		newVariant.setValore("XL");
		newVariant.setProdotto(p);

		entityManager.persist(newVariant);

		Variante newVariant2 = new Variante();
		newVariant2.setAttributo("Taglia");
		newVariant2.setValore("XS");
		newVariant2.setProdotto(p);

		entityManager.persist(newVariant2);

		TypedQuery<Prodotto> queryAll = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);
		List<Prodotto> prodotti = queryAll.getResultList(); 
		Assertions.assertThat(prodotti.get(0)).extracting("varianti").asList().hasSize(6); //4 già inserite + 2 inserite ora 

	}

	@Test
	void checkDeletedRelation(){
		TypedQuery<Fornitore> q1 = entityManager.createQuery("SELECT f FROM Fornitore f WHERE id = 1", Fornitore.class);
		Fornitore f1 = q1.getSingleResult();

		Prodotto p = new Prodotto();
		p.setNome("x");
		p.setDescrizione("x");
		p.setPrezzo(1F);
		p.setPrezzoNetto(0.8F);

		entityManager.persist(p);

		f1.getProdotti().add(p);

		entityManager.persist(f1);

		TypedQuery<Fornitore> queryAll = entityManager.createQuery("SELECT f FROM Fornitore f", Fornitore.class);
		List<Fornitore> fornitori = queryAll.getResultList();

		Assertions.assertThat(fornitori.get(0)).extracting("prodotti").asList().hasSize(2);

		entityManager.remove(f1);

		TypedQuery<Prodotto> queryProdotto = entityManager.createQuery("SELECT p FROM Prodotto p WHERE id = " + p.getId(), Prodotto.class);
		Prodotto prodotto = queryProdotto.getSingleResult();

		Assertions.assertThat(prodotto).extracting("fornitori").asList().hasSize(0);
	
	}
}
