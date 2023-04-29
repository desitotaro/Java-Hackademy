package it.aulab.finalproject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.finalproject.dto.LessonDTO;
import it.aulab.finalproject.model.Lesson;
import it.aulab.finalproject.repository.LessonRepository;
import it.aulab.finalproject.util.exception.LessonNotFound;

@Service("lessonService")
public class LessonService implements CrudService<LessonDTO, Long, LessonDTO, LessonDTO>{
    
    @Autowired
    private LessonRepository lessonRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Override
    public List<LessonDTO> readAll() {
        List<LessonDTO> dtos = new ArrayList<LessonDTO>();
        for(Lesson s : lessonRepository.findAll()){
            dtos.add(mapper.map(s, LessonDTO.class));
        }
        return dtos;
    }
    
    @Override
    public List<LessonDTO> read(Map<String, String> params) {
        String descriptionFilter = params.get("description");
        List<Lesson> lessons;
        if (descriptionFilter != null){
            lessons = lessonRepository.findByDescription(descriptionFilter);
        } else {
            lessons = lessonRepository.findAll();
        }
        
        return lessons.stream().map((l) -> mapper.map(l, LessonDTO.class)).toList();
    }
    
    @Override
    public LessonDTO readOne(Long id) throws Exception {
        return mapper.map(this.exists(id), LessonDTO.class);
    }
    
    @Override
    public LessonDTO create(LessonDTO createDTO) {
        Lesson lesson = mapper.map(createDTO, Lesson.class);
        return mapper.map(lessonRepository.save(lesson), LessonDTO.class);
    }
    
    @Override
    public LessonDTO update(Long id, LessonDTO updateDTO) throws Exception {
        Lesson dbLesson = this.exists(id);
        dbLesson.setDescription(updateDTO.getDescription());
        dbLesson.setDate(LocalDate.parse(updateDTO.getDate()));
        lessonRepository.save(dbLesson);
        return mapper.map(dbLesson, LessonDTO.class);
    }
    
    @Override
    public LessonDTO delete(Long id) throws Exception {
        Lesson lesson = this.exists(id);
        LessonDTO lessonDTO = mapper.map(lesson, LessonDTO.class);
        lessonRepository.delete(lesson);
        return lessonDTO;
    }
    
    private Lesson exists(Long id) throws Exception {
        if (lessonRepository.existsById(id)) {
            return lessonRepository.findById(id).get();
        } else {
            throw new LessonNotFound();
        }
    }
    
}
