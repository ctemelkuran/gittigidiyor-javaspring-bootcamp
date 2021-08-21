package dev.patika.patika0202.dao;

import dev.patika.patika0202.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO<Employee> extends BaseDAO<Employee> {
}
