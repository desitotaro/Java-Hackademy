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

import it.aulab.finalproject.dto.StudentDTO;
import it.aulab.finalproject.repository.CourseRepository;
import it.aulab.finalproject.service.CrudService;

@Controller
@RequestMapping(value = "students")
public class StudentsController {
    
    @Autowired
    private CrudService<StudentDTO, Long, StudentDTO, StudentDTO> studentService;

    @Autowired
    private CourseRepository courseRepository;
    
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("title", "Hack Java - Students");
        model.addAttribute("student", studentService.readAll());
        return "student";
    }
    
    @GetMapping("{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Hack Java - Students");
        model.addAttribute("students", studentService.readOne(id));
        model.addAttribute("course", courseRepository.findAll());
        return "editStudent";
    }
    
    @PostMapping("update")
    public String updateCourse(@ModelAttribute("student") StudentDTO updateCourseDTO) throws Exception {
        studentService.update(updateCourseDTO.getId(), updateCourseDTO);
            return "redirect:/students";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) throws Exception {
        studentService.delete(id);
        return "redirect:/students";
    }
}
