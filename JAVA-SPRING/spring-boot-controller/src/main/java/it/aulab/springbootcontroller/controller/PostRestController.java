package it.aulab.springbootcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.springbootcontroller.dto.CreatePostDTO;
import it.aulab.springbootcontroller.dto.PostDTO;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.PostRepository;

@RestController
@RequestMapping(value = "api/posts")
public class PostRestController {

    @Autowired
    AuthorRepository authorRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    private PostRepository postRepository;
    
    @GetMapping
    public List<PostDTO> getAll(){
        List<PostDTO> dtos = new ArrayList<PostDTO>();
        for(Post p : postRepository.findAll()){
            PostDTO map = modelMapper.map(p, PostDTO.class);
            dtos.add(map);
        }
        return dtos;
    }
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PostDTO post(@RequestBody CreatePostDTO createPostDto) {
        Post post = modelMapper.map(createPostDto, Post.class);
        post = postRepository.save(post);
        post.setAuthor(authorRepository.findById(post.getAuthor().getId()).get());
        return modelMapper.map(post, PostDTO.class);
    }
    
}
