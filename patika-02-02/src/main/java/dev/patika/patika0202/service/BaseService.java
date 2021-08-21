package dev.patika.patika0202.service;

import dev.patika.patika0202.model.Employee;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(int id);
    Employee save(T object);
    void deleteById(int id);


}
