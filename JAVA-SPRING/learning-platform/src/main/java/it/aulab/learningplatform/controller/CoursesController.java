package it.aulab.learningplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.model.Course;
import it.aulab.learningplatform.repository.StudentRepository;
import it.aulab.learningplatform.service.CrudService;

@Controller
@RequestMapping(value = "courses")
public class CoursesController {
    
    @Autowired
    private CrudService<CourseDTO, Long, CreateCourseDTO, UpdateCourseDTO> courseService;

    @Autowired
    private StudentRepository studentRepository;
    
    // show
    @GetMapping
    public String showListView(Model model) {
        model.addAttribute("title", "Learning Platform - Courses");
        model.addAttribute("courses", courseService.readAll());
        return "courses";
    }
    
    // modify
    @GetMapping("{id}")
    public String modifyCourseView(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Learning Platform - Course");
        model.addAttribute("course", courseService.readOne(id));
        model.addAttribute("students", studentRepository.findAll());
        return "modifyCourse";
    }
    
    // update
    @PostMapping("update")
    public String updateCourse(@ModelAttribute("course") UpdateCourseDTO updateCourseDTO) throws Exception {
        // update ha due parametri, id e updatecourse. non avendo inserito l'id ce lo prendiamo
        //da updatecourseDto (input hidden nel form)
        courseService.update(updateCourseDTO.getId(), updateCourseDTO);
            return "redirect:/courses";
    }

    //delete
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) throws Exception {
        courseService.delete(id);
        return "redirect:/courses";
    }

}
