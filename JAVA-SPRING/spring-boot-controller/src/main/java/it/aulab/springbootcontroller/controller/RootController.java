package it.aulab.springbootcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RootController {
    
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/")
    //se dobbiamo gestire delle liste dobbiamo sempre restituire una stringa
    // con il path che deve renderizzare
    public String root(Model model){
        model.addAttribute("title", "Homepage");
        model.addAttribute("authorsPath", "authors");
        model.addAttribute("postsPath", "posts");
        model.addAttribute("commentsPath", "comments");
        return "index";
    }
}
