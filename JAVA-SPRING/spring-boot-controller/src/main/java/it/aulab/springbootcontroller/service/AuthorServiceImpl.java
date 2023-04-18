package it.aulab.springbootcontroller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.springbootcontroller.dto.AuthorDTO;
import it.aulab.springbootcontroller.model.Author;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.PostRepository;
import jakarta.transaction.Transactional;
import it.aulab.springbootcontroller.util.exception.AuthorBadRequest;
import it.aulab.springbootcontroller.util.exception.AuthorNotFound;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
	public void transaction(){
		
		Author a = new Author();
		a.setFirstname("null");
		a.setLastname("null");
		a.setEmail("null");

		a = authorRepository.save(a);
		Post p1 = new Post();
		p1.setAuthor(a);
		p1.setBody("Lorem ipsum");
		p1.setTitle("Lorem ipsum");
		p1.setPublishDate("20230414");

		postRepository.save(p1);

		Post p2 = new Post();
		p2.setAuthor(a);
		p2.setBody("Lorem ipsum 2");
		p2.setPublishDate("20230414");

		throw new RuntimeException();
	}

    @Override
    public void noTransaction(){
        Author a = new Author();
        a.setFirstname("null");
        a.setLastname("null");
        a.setEmail("null");

        a = authorRepository.save(a);
        Post p1 = new Post();
        p1.setAuthor(a);
        p1.setBody("Lorem ipsum");
        p1.setTitle("Lorem ipsum");
        p1.setPublishDate("20230414");

        postRepository.save(p1);

        Post p2 = new Post();
        p2.setAuthor(a);
        p2.setBody("Lorem ipsum 2");
        //p2.setTitle("Lorem ipsum");
        p2.setPublishDate("20230414");

        postRepository.save(p2);
}

@Override
	public List<AuthorDTO> readAll() {
		List<AuthorDTO> dtos = new ArrayList<AuthorDTO>();

		for (Author author: authorRepository.findAll()) {
			dtos.add(modelMapper.map(author, AuthorDTO.class));
		}

		return dtos;
	}

	@Override
	public List<AuthorDTO> read(String firstname, String lastname) {
		List<AuthorDTO> dtos = new ArrayList<AuthorDTO>();
		List<Author> authors;

        if (firstname != null && lastname != null) {
            authors = authorRepository.findByFirstnameAndLastname(firstname, lastname);
        } else if (firstname != null) {
            authors = authorRepository.findByFirstname(firstname);
        } else if (lastname != null) {
            authors = authorRepository.findByLastname(lastname);
        } else {
            authors = authorRepository.findAll();
        }

		for (Author author: authors) {
			dtos.add(modelMapper.map(author, AuthorDTO.class));
		}

		return dtos;
	}

	@Override
	public AuthorDTO readOne(Long id) throws Exception {
		Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            return modelMapper.map(optionalAuthor.get(), AuthorDTO.class);
        }
        throw new AuthorNotFound();
	}

@Override
	public AuthorDTO create(Author author) throws Exception {
	
		if (author.getFirstname() == null || author.getLastname() == null || author.getEmail() == null) {
			if (author.getFirstname() == null)
				throw new AuthorBadRequest("Firstname is required");
			if (author.getLastname() == null)
				throw new AuthorBadRequest("Lastname is required");
			if (author.getEmail() == null)
				throw new AuthorBadRequest("Email is required");
		}
		return modelMapper.map(authorRepository.save(author), AuthorDTO.class);
	}

	@Override
	public AuthorDTO update(Long id, Author author) throws Exception {
        Optional<Author> dbOptionalAuthor = authorRepository.findById(id);
        if (dbOptionalAuthor.isPresent()) {
            Author dbAuthor = dbOptionalAuthor.get();
            dbAuthor.setFirstname(author.getFirstname());
            dbAuthor.setLastname(author.getLastname());
            dbAuthor.setEmail(author.getEmail());
            authorRepository.save(dbAuthor);
            return modelMapper.map(dbAuthor, AuthorDTO.class);
        }
        throw new AuthorNotFound();
	}

	@Override
	public String delete(Long id) throws Exception {
		if (authorRepository.findById(id).isPresent()) {
			authorRepository.deleteById(id);
			return "OK";
		}
        throw new AuthorNotFound();
	}




}
