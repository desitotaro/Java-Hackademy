package it.aulab.springbootcontroller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.springbootcontroller.dto.AuthorDTO;
import it.aulab.springbootcontroller.model.Author;
import it.aulab.springbootcontroller.service.AuthorService;

@RestController
@RequestMapping(value = "api/authors")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public List<AuthorDTO> getAll(
        @RequestParam(name = "firstname", required = false) String firstname, 
        @RequestParam(name = "lastname", required = false) String lastname
    ){
        return authorService.read(firstname, lastname);
    } 
    
    @GetMapping("{id}")
    public AuthorDTO getOne(
        @PathVariable("id") Long id
    ) throws Exception {
        return authorService.readOne(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public AuthorDTO post(@RequestBody Author author) throws Exception {
        return authorService.create(author);
    }


    @PutMapping("{id}")
    public AuthorDTO put(@PathVariable("id") Long id, @RequestBody Author author) throws Exception {
        return authorService.update(id, author);
    }


    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) throws Exception {
        return authorService.delete(id);
    }

}
