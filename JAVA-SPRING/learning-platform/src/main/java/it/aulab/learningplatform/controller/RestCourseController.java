package it.aulab.learningplatform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.service.CrudService;

@RestController
@RequestMapping("api/courses")
public class RestCourseController {
    
    @Autowired
    // se non dichiaro il qualifier non riesce a fare l'injection di queste generics
    @Qualifier("courseService")
    private CrudService<CourseDTO, Long, CreateCourseDTO, UpdateCourseDTO> courseService;
    
 /*    @Autowired
    private CourseService courseServiceImpl; */
    
    @GetMapping("all")
    public List<CourseDTO> getAll(@RequestParam Map<String,String> params){
        /*       for(String p : params.keySet()){
            System.out.println("key: " + p );
            System.out.println("value: " + params.get(p));
        }
        return new ArrayList<CourseDTO>(); */
        return courseService.readAll(); 
        /* return courseServiceImpl.readAll(); */
    }
    
    @GetMapping
    public List<CourseDTO> get(@RequestParam Map<String,String> params){
        return courseService.read(params);
    }

    @GetMapping("{id}")
    public CourseDTO getOne(@PathVariable("id") Long id) throws Exception{
        return courseService.readOne(id);
    }

    @PostMapping
    public CourseDTO insert(@RequestBody CreateCourseDTO createCourseDTO){
        return courseService.create(createCourseDTO);
    }

    //PUT -> modifica tutti i campi presenti nel body
    //PATCH -> modifica solo i campi presenti nel body, quindi se inserisco solo una nuova description
    //modifica solo quest'ultima. 
    @PutMapping("{id}")
    public CourseDTO putOne(@PathVariable("id") Long id, @RequestBody UpdateCourseDTO updateCourseDto) throws Exception {
        return courseService.update(id, updateCourseDto);
    }

    @DeleteMapping("{id}")
    public CourseDTO putOne(@PathVariable("id") Long id) throws Exception {
        return courseService.delete(id);
    }

    
}
