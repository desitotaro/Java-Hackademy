package it.jdbc;

import java.util.List;

public interface Dao<T>{
    public Integer count();
    public T getOneObject(Long id);
    public List<T> getObjects();
    public boolean insert(T model);
    public boolean update(Long id, T model);
    public boolean delete(Long id);
}
