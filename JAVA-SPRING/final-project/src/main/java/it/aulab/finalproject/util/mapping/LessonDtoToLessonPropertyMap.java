package it.aulab.finalproject.util.mapping;

import org.modelmapper.PropertyMap;

import it.aulab.finalproject.dto.LessonDTO;
import it.aulab.finalproject.model.Lesson;

public class LessonDtoToLessonPropertyMap extends PropertyMap<Lesson, LessonDTO>{
    
    @Override
    protected void configure() {
        using(new ConvertStringToDate()).map(source.getDate()).setDate(null);
    } 

}