package it.aulab.finalproject.util.mapping;
import org.modelmapper.PropertyMap;

import it.aulab.finalproject.dto.CreateCourseDTO;
import it.aulab.finalproject.model.Course;

public class CreateCourseDtoToCoursePropertyMap extends PropertyMap<CreateCourseDTO, Course>{
    @Override
    protected void configure() {
        using(new ConvertStringToDate()).map(source.getDate()).setDate(null);
    } 
}
