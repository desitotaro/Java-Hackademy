package it.aulab.learningplatform.model;

// date
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// JAVA PERSISTENCE API > JPA 
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name ="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    
    @Embedded 
    @AttributeOverrides({
        @AttributeOverride(
        name = "firstname", 
        column = @Column(
        name="teacher_firstname",
        nullable = false,
        length = 100)
        ), 
        @AttributeOverride(
        name = "lastname", 
        column = @Column(
        name="teacher_lastname", 
        nullable = false,
        length = 100)
        )
    })
    private Person teacher;
    

    private LocalDate date;

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties("course")
    private List<Lesson> lessons = new ArrayList<Lesson>();
    
    @ManyToMany
    @JsonIgnoreProperties("courses")
    @JoinTable(
        name = "courses_students", 
        joinColumns = @JoinColumn(name = "course_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "student_id", nullable = false)
    )
    private List<Student> students = new ArrayList<Student>();
    
    public Course() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Person getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public List<Lesson> getLessons() {
        return lessons;
    }
    
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
