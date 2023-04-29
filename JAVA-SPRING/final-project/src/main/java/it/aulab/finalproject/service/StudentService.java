package it.aulab.finalproject.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.finalproject.dto.StudentDTO;
import it.aulab.finalproject.model.Student;
import it.aulab.finalproject.repository.StudentRepository;
import it.aulab.finalproject.util.exception.StudentNotFound;

@Service("studentService")
public class StudentService implements CrudService<StudentDTO, Long, StudentDTO, StudentDTO>{
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Override
    public List<StudentDTO> readAll() {
        List<StudentDTO> dtos = new ArrayList<StudentDTO>();
        for(Student s : studentRepository.findAll()){
            dtos.add(mapper.map(s, StudentDTO.class));
        }
        
        return dtos;
    }

    @Override
    public List<StudentDTO> read(Map<String, String> params) {
        String firstnameFilter = params.get("firstname");
        String lastnameFilter = params.get("lastname");
        List<Student> students;

        if(firstnameFilter != null && lastnameFilter != null){
            students = studentRepository.findByFirstnameAndLastname(firstnameFilter, lastnameFilter);
        } else if (firstnameFilter != null){
            students = studentRepository.findByFirstname(firstnameFilter);
        } else if (lastnameFilter != null){
            students = studentRepository.findByLastname(lastnameFilter);
        } else {
            students = studentRepository.findAll();
        }

        return students.stream().map((s) -> mapper.map(s, StudentDTO.class)).toList();
    }

    @Override
    public StudentDTO readOne(Long id) throws Exception {
        return mapper.map(this.exists(id), StudentDTO.class);
    }

    @Override
    public StudentDTO create(StudentDTO createDTO) {
        Student student = mapper.map(createDTO, Student.class);
        return mapper.map(studentRepository.save(student), StudentDTO.class);
    }

    @Override
    public StudentDTO update(Long id, StudentDTO updateDTO) throws Exception {
        Student dbStudent = this.exists(id);
        dbStudent.setEmail(updateDTO.getEmail());
        dbStudent.setCourses(updateDTO.getCourses());
        studentRepository.save(dbStudent);
        return mapper.map(dbStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO delete(Long id) throws Exception {
        Student student = this.exists(id);
        StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
        studentRepository.delete(student);
        return studentDTO;
    }

    private Student exists(Long id) throws Exception {
        if (studentRepository.existsById(id)) {
            return studentRepository.findById(id).get();
        } else {
            throw new StudentNotFound();
        }
    }
    
}
