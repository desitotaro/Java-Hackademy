package it.aulab.learningplatform.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.model.Course;
import it.aulab.learningplatform.repository.CourseRepository;
import it.aulab.learningplatform.util.exception.CourseNotFound;

@Service("courseService")
public class CourseService implements CrudService<CourseDTO, Long, CreateCourseDTO, UpdateCourseDTO> {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Override
    public List<CourseDTO> read(Map<String, String> params) {
        // Abbiamo 3 parametri, name - description - teacher
        // facciamo ricercare quindi per questi 3 parametri:
        String nameFilter = params.get("name");
        String teacherFirstnameFilter = params.get("teacherFirstname");
        String teacherLastnameFilter = params.get("teacherLastname");
        // potrebbero essere null, quindi facciamo delle condizioni:
        // ognuno dei casi mi restituisce una lista di courses
        List<Course> courses;
        
        // tutti e 3 diversi da null
        if (nameFilter != null && teacherFirstnameFilter != null && teacherLastnameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(
            nameFilter, teacherFirstnameFilter, teacherLastnameFilter);
            // il resto delle casistiche
        } else if (teacherFirstnameFilter != null && teacherLastnameFilter != null) {
            courses = courseRepository.findByTeacherFirstnameContainingAndTeacherLastnameContaining(
            teacherFirstnameFilter, teacherLastnameFilter);
        } else if (teacherFirstnameFilter != null && nameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherFirstnameContaining(nameFilter,
            teacherFirstnameFilter);
        } else if (teacherLastnameFilter != null && nameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherLastnameContaining(nameFilter,
            teacherLastnameFilter);
            // se uno dei 3
        } else if (nameFilter != null) {
            courses = courseRepository.findByNameContaining(nameFilter);
        } else if (teacherFirstnameFilter != null) {
            courses = courseRepository.findByTeacherFirstnameContaining(teacherFirstnameFilter);
        } else if (teacherLastnameFilter != null) {
            courses = courseRepository.findByTeacherLastnameContaining(teacherLastnameFilter);
        } else {
            courses = courseRepository.findAll();
        }
        // programmazione funzionale
        return courses.stream().map((c) -> mapper.map(c, CourseDTO.class)).toList();
    }
    
    @Override
    public CourseDTO readOne(Long id) throws Exception {
  /*       Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()){
            return mapper.map(optionalCourse.get(), CourseDTO.class); 
        } 
        throw new CourseNotFound(); */
        //usiamo la funzione exists()
        return mapper.map(this.exists(id), CourseDTO.class);
    }
    
    @Override
    public List<CourseDTO> readAll() {
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        for(Course c : courseRepository.findAll()){
            dtos.add(mapper.map(c, CourseDTO.class));
        }
        
        return dtos;
    }
    
    @Override
    public CourseDTO create(CreateCourseDTO createDTO) {
        Course course = mapper.map(createDTO, Course.class);
        return mapper.map(courseRepository.save(course), CourseDTO.class);
    }
    
    @Override
    public CourseDTO update(Long id, UpdateCourseDTO updateDTO) throws Exception {
        Course dbCourse = this.exists(id);
        dbCourse.setDescription(updateDTO.getDescription());
        dbCourse.setDate(LocalDate.parse(updateDTO.getDate()));
        courseRepository.save(dbCourse);
        return mapper.map(dbCourse, CourseDTO.class);
    }
    
    
    // implementazione per controllare se il corso esiste
    private Course exists(Long id) throws Exception {
        if (courseRepository.existsById(id)) {
            return courseRepository.findById(id).get();
        } else {
            throw new CourseNotFound();
        }
    }

    @Override
    public CourseDTO delete(Long id) throws Exception {
        Course course = this.exists(id);
        CourseDTO courseDto = mapper.map(course, CourseDTO.class);
        courseRepository.delete(course);
        return courseDto;
    }

}
