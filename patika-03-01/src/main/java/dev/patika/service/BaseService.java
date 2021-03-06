package dev.patika.service;

import dev.patika.entity.Employee;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(int id);
    Employee save(T object);
    void deleteById(int id);


}
