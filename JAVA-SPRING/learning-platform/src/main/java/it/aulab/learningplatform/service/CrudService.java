package it.aulab.learningplatform.service;

import java.util.List;
import java.util.Map;

//INTERFACCIA GENERICA PER I SERVICE
public interface CrudService<Read, ID, Create, Update> {
    List<Read> readAll();
    List<Read> read(Map<String, String> params);
    Read readOne(ID id) throws Exception;
    Read create(Create createDTO);
    Read update(ID id, Update updateDTO) throws Exception;
    Read delete(ID id) throws Exception;

}
