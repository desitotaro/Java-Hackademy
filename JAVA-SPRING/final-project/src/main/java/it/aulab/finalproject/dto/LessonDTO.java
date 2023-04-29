package it.aulab.finalproject.dto;

public class LessonDTO {
    private Long id;
    private String description;
    private String date;
    private CourseDTO course;
    public LessonDTO() {
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
    public CourseDTO getCourse() {
        return course;
    }
    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
