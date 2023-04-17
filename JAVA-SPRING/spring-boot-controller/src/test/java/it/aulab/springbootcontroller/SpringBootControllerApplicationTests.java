package it.aulab.springbootcontroller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import it.aulab.springbootcontroller.model.Author;
import it.aulab.springbootcontroller.model.Comment;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.CommentRepository;
import it.aulab.springbootcontroller.repository.PostRepository;
import it.aulab.springbootcontroller.service.AuthorService;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringBootControllerApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	AuthorService authorService;

	@BeforeEach
	public void createData(){
		
		commentRepository.deleteAll();
		postRepository.deleteAll();
		authorRepository.deleteAll();

		Author a = new Author();
		a.setFirstname("Desiree");
		a.setLastname("Totaro");
		a.setEmail("desitotaro@aulab.it");
		
		authorRepository.save(a);
		
		Author b = new Author();
		b.setFirstname("Andrea");
		b.setLastname("Rossi");
		b.setEmail("andrearossi@aulab.it");
		
		authorRepository.save(b);

		Post p = new Post();
		p.setAuthor(a);
		p.setTitle("Hello World");
		p.setBody("Lorem Ipsum Dolor");
		p.setPublishDate("20230202");
		
		postRepository.save(p);
		
		Post p2 = new Post();
		p2.setAuthor(a);
		p2.setTitle("Hello World");
		p2.setBody("Lorem Ipsum Dolor");
		p2.setPublishDate("20230202");
		
		postRepository.save(p2); 
		
		Comment c1 = new Comment();
		c1.setEmail("andrea@aulab.it");
		c1.setPost(p);
		c1.setBody("Mi piace");
		c1.setPublishDate("20230202");
		Comment c2 = new Comment();
		
		c2.setEmail("andrea@aulab.it");
		c2.setPost(p2);
		c2.setBody("Non mi piace");
		c2.setPublishDate("20230203");
		
		Comment c3 = new Comment();
		c3.setEmail("desitotaro@aulab.it");
		c3.setPost(p2);
		c3.setBody("Bellissimo, consigliato");
		c3.setPublishDate("20230412");

		List<Comment> commentList = new ArrayList<Comment>();
		commentList.add(c1);
		commentList.add(c2);
		commentList.add(c3);

		commentRepository.saveAll(commentList);

	}
	
	@Test
	void customQuery() {
		/* Fa la join in automatico */
		List<Post> posts = postRepository.findDesiree();

		assertThat(posts).hasSize(1);
		assertThat(posts.get(0))
				.extracting("author")
				.extracting("firstname")
				.isEqualTo("Desiree");
	}

	@Test 
	void anotherQuery(){
		Author a = new Author();
		a.setFirstname("Desiree");
		a.setLastname("Ciccio");
		a.setEmail("desireeciccio@aulab.it");

		authorRepository.save(a);

		Post p = new Post();
		p.setAuthor(a);
		p.setTitle("Che bella giornata");
		p.setBody("Lorem ipsum");
		p.setPublishDate("20230411");

		postRepository.save(p);

		List<Post> posts = postRepository.findByAuthorFirstname("Desiree");

		assertThat(posts).hasSize(2);
		assertThat(posts)
				.extracting("author")
				.extracting("firstname")
				.contains("Desiree", "Desiree");

	}

	@Test
	void findByLastAndFirst(){
		List<Post> posts = postRepository.findByAuthorFirstnameAndLastname("Totaro", "Desiree");

		assertThat(posts).hasSize(1);
		assertThat(posts)
				.first()
				.extracting("author")
				.extracting("firstname")
				.isEqualTo("Desiree");

		assertThat(posts.get(0))
				.extracting("author")
				.extracting("lastname")
				.isEqualTo("Totaro");

	}

	@Test
	void testTransaction() {
		try {
			authorService.noTransaction();
			//authorService.transaction();
		} catch (Exception e) {
			assertThat(postRepository.findByAuthorFirstnameAndLastname("null", "null")).hasSize(0);
			assertThat(authorRepository.findByFirstnameAndLastname("null", "null")).hasSize(0);
		}

	} 




}
