package it.aulab.springbootcontroller.util.mapper;

import java.util.Collection;

import org.modelmapper.AbstractConverter;

public class ConvertCollectionToInteger extends AbstractConverter<Collection<?>, Integer> {

    @Override
    // ci permette di convertire l'intero a partire da una collection
    protected Integer convert(Collection<?> source) {
        return source.size();
    }

}
