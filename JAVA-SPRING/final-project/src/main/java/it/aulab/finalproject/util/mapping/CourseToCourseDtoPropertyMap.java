package it.aulab.finalproject.util.mapping;

import org.modelmapper.PropertyMap;

import it.aulab.finalproject.dto.CourseDTO;
import it.aulab.finalproject.model.Course;

public class CourseToCourseDtoPropertyMap extends PropertyMap<Course, CourseDTO>{
    
    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getStudents()).setNumberOfStudents(null);
    }

}