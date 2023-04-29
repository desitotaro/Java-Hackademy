package it.aulab.finalproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.finalproject.dto.CourseDTO;
import it.aulab.finalproject.dto.CreateCourseDTO;
import it.aulab.finalproject.dto.UpdateCourseDTO;
import it.aulab.finalproject.repository.StudentRepository;
import it.aulab.finalproject.service.CrudService;

@Controller
@RequestMapping(value = "courses")
public class CoursesController {
    
    @Autowired
    private CrudService<CourseDTO, Long, CreateCourseDTO, UpdateCourseDTO> courseService;

    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping
    public String showListView(Model model) {
        model.addAttribute("title", "Learning Platform - Courses");
        model.addAttribute("courses", courseService.readAll());
        return "courses";
    }
    
    @GetMapping("{id}")
    public String editCourseView(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Learning Platform - Course");
        model.addAttribute("course", courseService.readOne(id));
        model.addAttribute("students", studentRepository.findAll());
        return "editCourse";
    }
    
    @PostMapping("update")
    public String updateCourse(@ModelAttribute("course") UpdateCourseDTO updateCourseDTO) throws Exception {
        courseService.update(updateCourseDTO.getId(), updateCourseDTO);
            return "redirect:/courses";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) throws Exception {
        courseService.delete(id);
        return "redirect:/courses";
    }
}
