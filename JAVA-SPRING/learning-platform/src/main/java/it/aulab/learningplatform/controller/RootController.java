package it.aulab.learningplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class RootController {
    
    @GetMapping("/")
    public String root(Model model){
        model.addAttribute("title", "Learning Platform");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title", "Login Learning Platform");
        return "login";
    }
}
