package it.aulab.springbootcontroller.service;

import java.util.List;

import it.aulab.springbootcontroller.dto.CreatePostDTO;
import it.aulab.springbootcontroller.dto.PostDTO;

public interface PostService {
    List<PostDTO> readAll();
    PostDTO create(CreatePostDTO post) throws Exception;

}

