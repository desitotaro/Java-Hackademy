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

import it.aulab.finalproject.dto.LessonDTO;
import it.aulab.finalproject.service.CrudService;

@RestController
@RequestMapping("api/lessons")
public class RestLessonController {

    @Autowired
    @Qualifier("lessonService")
    private CrudService<LessonDTO, Long, LessonDTO, LessonDTO> lessonService;

    @GetMapping("all")
    public List<LessonDTO> getAll(@RequestParam Map<String,String> params){
        return lessonService.readAll(); 
    }
    
    @GetMapping
    public List<LessonDTO> get(@RequestParam Map<String,String> params){
        return lessonService.read(params);
    }

    @GetMapping("{id}")
    public LessonDTO getOne(@PathVariable("id") Long id) throws Exception{
        return lessonService.readOne(id);
    }

    @PostMapping
    public LessonDTO insert(@RequestBody LessonDTO createLessonDTO){
        return lessonService.create(createLessonDTO);
    }

    @PutMapping("{id}")
    public LessonDTO putOne(@PathVariable("id") Long id, @RequestBody LessonDTO updateLessonDTO) throws Exception {
        return lessonService.update(id, updateLessonDTO);
    }

    @DeleteMapping("{id}")
    public LessonDTO putOne(@PathVariable("id") Long id) throws Exception {
        return lessonService.delete(id);
    }
}
