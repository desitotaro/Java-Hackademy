package it.aulab.finalproject.controller;

import java.util.List;
import java.util.Map;

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

import it.aulab.finalproject.dto.StudentDTO;
import it.aulab.finalproject.service.CrudService;

@RestController
@RequestMapping("api/students")
public class RestStudentController {

    @Autowired
    @Qualifier("studentService")
    private CrudService<StudentDTO, Long, StudentDTO, StudentDTO> studentService;

    @GetMapping("all")
    public List<StudentDTO> getAll(@RequestParam Map<String,String> params){
        return studentService.readAll(); 
    }
    
    @GetMapping
    public List<StudentDTO> get(@RequestParam Map<String,String> params){
        return studentService.read(params);
    }

    @GetMapping("{id}")
    public StudentDTO getOne(@PathVariable("id") Long id) throws Exception{
        return studentService.readOne(id);
    }

    @PostMapping
    public StudentDTO insert(@RequestBody StudentDTO createStudentDTO){
        return studentService.create(createStudentDTO);
    }

    @PutMapping("{id}")
    public StudentDTO putOne(@PathVariable("id") Long id, @RequestBody StudentDTO updateStudentDTO) throws Exception {
        return studentService.update(id, updateStudentDTO);
    }

    @DeleteMapping("{id}")
    public StudentDTO putOne(@PathVariable("id") Long id) throws Exception {
        return studentService.delete(id);
    }
}
