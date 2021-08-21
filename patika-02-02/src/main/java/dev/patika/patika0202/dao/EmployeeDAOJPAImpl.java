package dev.patika.patika0202.dao;

import dev.patika.patika0202.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;


public class EmployeeDAOJPAImpl implements EmployeeDAO<Employee> {
    private EntityManager entityManager;

    @Autowired // yazmasak da olur
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("FROM Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void save(Employee employee) {
entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {

    }
}
