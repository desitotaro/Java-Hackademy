package it.aulab.finalproject.dto;

import java.util.List;

import it.aulab.finalproject.model.Student;

public class UpdateCourseDTO {
   private Long id;
   private String description;
   private String date;
   private List<Long> addedStudentsIds;
   private List<Long> removedStudentsIds;
   private List<Student> students;

public UpdateCourseDTO() {
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public String getDate() {
    return date;
}
public void setDate(String date) {
    this.date = date;
}
public List<Long> getAddedStudentsIds() {
    return addedStudentsIds;
}
public void setAddedStudentsIds(List<Long> addedStudentsIds) {
    this.addedStudentsIds = addedStudentsIds;
}
public List<Long> getRemovedStudentsIds() {
    return removedStudentsIds;
}
public void setRemovedStudentsIds(List<Long> removedStudentsIds) {
    this.removedStudentsIds = removedStudentsIds;
}
public List<Student> getStudents() {
    return students;
}
public void setStudents(List<Student> students) {
    this.students = students;
}
}
