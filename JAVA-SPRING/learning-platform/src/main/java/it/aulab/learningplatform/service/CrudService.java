package it.aulab.learningplatform.service;

import java.util.List;
import java.util.Map;

//INTERFACCIA GENERICA PER I SERVICE
public interface CrudService<Read, ID, Create, Update> {
    List<Read> read(Map<String,String> params);
    List<Read> readOne(ID id);
    List<Read> readAll();
    Read create(Create createDTO);
    Read update(Update createDTO);
    Read delete(ID id);
}
