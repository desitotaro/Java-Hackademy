package it.aulab.springblog;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import it.aulab.springblog.repository.AuthorRepository;
import it.aulab.springblog.repository.CrudAuthorRepository;
import it.aulab.springblog.repository.PagingAndSortingAuthorRepository;
import it.aulab.springblog.model.Author;
import it.aulab.springblog.model.Comment;
import it.aulab.springblog.model.Post;
import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringBlogApplicationTests {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private CrudAuthorRepository crudAuthorRepository;
	
	@Autowired
	private PagingAndSortingAuthorRepository pagingAndSortingAuthorRepository;
	
	@BeforeEach
	public void createData(){
		
		Author a = new Author();
		a.setFirstname("Desiree");
		a.setLastname("Totaro");
		a.setEmail("desitotaro@aulab.it");
		
		entityManager.persist(a);
		
		Author b = new Author();
		b.setFirstname("Andrea");
		b.setLastname("Rossi");
		b.setEmail("andrearossi@aulab.it");
		
		entityManager.persist(b);
		
		Post p = new Post();
		p.setAuthor(a);
		p.setTitle("Hello World");
		p.setBody("Lorem Ipsum Dolor");
		p.setPublishDate("20230202");
		
		entityManager.persist(p);
		
		Post p2 = new Post();
		p2.setAuthor(a);
		p2.setTitle("Hello World");
		p2.setBody("Lorem Ipsum Dolor");
		p2.setPublishDate("20230202");
		
		entityManager.persist(p2);
		
		Comment c1 = new Comment();
		c1.setEmail("andrea@aulab.it");
		c1.setPost(p);
		c1.setBody("Mi piace");
		c1.setPublishDate("20230202");
		Comment c2 = new Comment();
		
		entityManager.persist(c1);
		
		c2.setEmail("andrea@aulab.it");
		c2.setPost(p);
		c2.setBody("Non mi piace");
		c2.setPublishDate("20230203");
		
		entityManager.persist(c2);
	}
	
	@Test
	void initialTest() {
		List<Author> authors = entityManager.createQuery("SELECT a From Author a", Author.class).getResultList();
		assertThat(authors).hasSize(1);
	}
	
	@Test
	void postCheck() {
		List<Post> posts = entityManager.createQuery("SELECT a From Post a", Post.class).getResultList();
		assertThat(posts).hasSize(2);
	}
	
	@Test
	void commentCheck() {
		
		List<Post> posts = entityManager.createQuery("SELECT p FROM Post p", Post.class)
		.getResultList();
		
		//System.out.println(posts.get(0).getId());
		List<Comment> commmentsPost1 = entityManager.createQuery(
		"SELECT c FROM Comment c WHERE c.post.id = ?1",
		Comment.class).setParameter(1, posts.get(0).getId())
		.getResultList();
		
		assertThat(commmentsPost1).hasSize(2);
		
		//System.out.println(posts.get(1).getId());
		List<Comment> commmentsPost2 = entityManager.createQuery(
		"SELECT c FROM Comment c WHERE c.post.id = ?1",
		Comment.class).setParameter(1, posts.get(1).getId())
		.getResultList();
		
		assertThat(commmentsPost2).hasSize(0);
	}
	
	@Test
	void queryCheck() {
		
		List<Post> posts = entityManager
		.createQuery("SELECT p FROM Post p", Post.class)
		.getResultList();
		
		// List<Comment> commment =
		// entityManager.createQuery(
		// "SELECT c FROM Comment c WHERE c.post.id = :id AND c.email = :email",
		// Comment.class
		// )
		// .setParameter("id", 1)
		// .setParameter("email", "andrea@aulab.it")
		// .getResultList();
		
		List<Comment> commment = entityManager.createQuery(
		"SELECT c FROM Comment c WHERE c.post.id = ?1 AND c.email = ?2",
		Comment.class)
		.setParameter(1, posts.get(0).getId())
		.setParameter(2, "andrea@aulab.it")
		.getResultList();
		
		/*
		* select c1_0.id,c1_0.body,c1_0.email,c1_0.post_id,c1_0.date
		* from comments c1_0
		* where
		* c1_0.post_id=?
		* and
		* c1_0.email=?
		*/
		
		assertThat(commment).hasSize(2);
	}
	
	@Test 
	void AuthorRepositorycheck(){
		
		assertThat(authorRepository.count()).isEqualTo(1);
		
		assertThat(authorRepository.findAll())
		.first()
		.extracting("firstname")
		.isEqualTo("Desiree");
		
		Author a = authorRepository.findAll().get(0);
		
		assertThat(authorRepository.findById(a.getId()).get())
		.isNotNull()
		.extracting("lastname")
		.isEqualTo("Totaro");
		
	}
	
	@Test 
	void findByLastname() {
		/*
		*
		* select a1_0.id,a1_0.email,a1_0.firstname,a1_0.lastname
		* from authors a1_0
		* where a1_0.lastname=?
		* 
		*/
		assertThat(authorRepository.findByLastname("Totaro"))
		.first()
		.extracting("lastname")
		.isEqualTo("Totaro");
	}
	
	@Test
	void findByFirstnameAndLastname() {
		
		/*
		* 
		* select a1_0.id,a1_0.email,a1_0.firstname,a1_0.lastname
		* from authors a1_0
		* where a1_0.firstname=?
		* and a1_0.lastname=?
		* 
		*/
		
		assertThat(authorRepository.findByFirstnameAndLastname("Andrea", "Totaro"))
		.hasSize(0);
		
		/*
		* 
		* select a1_0.id,a1_0.email,a1_0.firstname,a1_0.lastname
		* from authors a1_0
		* where a1_0.firstname=?
		* or a1_0.lastname=?
		* 
		*/
		
		assertThat(authorRepository.findByFirstnameOrLastname("andrea", "totaro"))
		.hasSize(2);
	}
	
	@Test
	void notIgnoreCase() {
		
		/*
		*
		* select a1_0.id,a1_0.email,a1_0.firstname,a1_0.lastname
		* from authors a1_0
		* where upper(a1_0.firstname) != upper(?)
		* 
		*/
		
		assertThat(authorRepository.findByFirstnameNotIgnoreCase("andrea"))
		.first()
		.extracting("firstname")
		.isEqualTo("Desiree");
		
		/*
		*
		* select a1_0.id,a1_0.email,a1_0.firstname,a1_0.lastname
		* from authors a1_0
		* where a1_0.firstname = ?
		* 
		*/
		
		assertThat(authorRepository.findByFirstnameEquals("desiree")).first()
		.extracting("firstname")
		.isEqualTo("Desiree");
		
		/*
		* 
		* select a1_0.id,a1_0.email,a1_0.firstname,a1_0.lastname
		* from authors a1_0
		* where a1_0.firstname like ? = '%r%'
		* escape '\\'
		* 
		*/
		
		assertThat(authorRepository.findByFirstnameContains("r")).hasSize(2);
		
	}
	
	@Test
	void createCrud(){
		Author a = new Author();
		a.setFirstname("Luca");
		a.setLastname("Rossi");
		a.setEmail("lucarossi@gmai.com");
		
		crudAuthorRepository.save(a);
		
		assertThat(crudAuthorRepository.findAll()).hasSize(3);
	}
	
	@Test
	void createJpa(){
		Author a = new Author();
		a.setFirstname("Luca");
		a.setLastname("Rossi");
		a.setEmail("lucarossi@gmai.com");
		
		authorRepository.save(a);
		assertThat(authorRepository.findAll()).hasSize(3);
	}
	
	@Test
	void sorting(){
		assertThat(pagingAndSortingAuthorRepository
		.findAll(Sort.by("lastname")))
		.first()
		.extracting("lastname")
		.isEqualTo("Rossi");
		
		/* DIRECTION.DESC o DIRECTION.ASC */
		assertThat(pagingAndSortingAuthorRepository
		.findAll(Sort.by("lastname")))
		.extracting("lastname")
		.contains("Rossi", atIndex(0))
		.contains("Totaro", atIndex(1));
	}
	
	@Test 
	void paging(){
		authorRepository.deleteAll();
		
		for (int i = 0; i < 100; i++) {
			/* In questo modo creiamo 100 righe */
			Author a = new Author();
			a.setFirstname(String.valueOf(i));
			a.setLastname(String.valueOf(i));
			a.setEmail(String.valueOf(i));
			
			authorRepository.save(a);
		}
		/* Possiamo fare il check in entrambi i modi */
		assertThat(authorRepository.findAll()).hasSize(100);
		/* In caso di tanti dati, il count è il più veloce */
		assertThat(authorRepository.count()).isEqualTo(100);
		
		/* Numero di pagine, 10, in ogni pagina ci sono 10 numeri*/
		
		int pageSize = 10;
		PageRequest.of(0, pageSize);
		assertThat(authorRepository.findAll(PageRequest.of(0, pageSize)).getContent())
		.extracting("firstname")
		.contains("0", atIndex(0))
		.contains("1", atIndex(1));
		
		assertThat(authorRepository.findAll(PageRequest.of(1, pageSize)).getContent())
		.extracting("lastname")
		.contains("10", atIndex(0))
		.contains("11", atIndex(1));
		
		assertThat(authorRepository.findAll(PageRequest.of(9, pageSize)).getContent())
		.extracting("email")
		.contains("98", atIndex(8))
		.contains("99", atIndex(9));
	}
	
	@Test
	void customRepository(){
		List<Author> find = authorRepository.findQualcosa("de");
		assertThat(find).hasSize(1);
		assertThat(find.get(0))
		.extracting("firstname")
		.isEqualTo("Desiree");
	}
}
