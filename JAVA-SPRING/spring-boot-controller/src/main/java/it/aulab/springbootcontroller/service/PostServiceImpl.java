package it.aulab.springbootcontroller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.springbootcontroller.dto.CreatePostDTO;
import it.aulab.springbootcontroller.dto.PostDTO;
import it.aulab.springbootcontroller.model.Author;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.PostRepository;
import it.aulab.springbootcontroller.util.exception.AuthorNotFound;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDTO> readAll() {
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for(Post p: postRepository.findAll()) {
            dtos.add(modelMapper.map(p, PostDTO.class));
        }

        return dtos;
    }

    @Override
    public PostDTO create(CreatePostDTO createPostDTO) throws Exception {
        Post p = modelMapper.map(createPostDTO, Post.class);
        postRepository.save(p);
        Optional<Author> optionalAuthor = authorRepository.findById(createPostDTO.getAuthorId());
        if (optionalAuthor.isPresent()) {
            p.setAuthor(optionalAuthor.get());
            return modelMapper.map(p, PostDTO.class);
        }
        throw new AuthorNotFound();
    }
    
}
