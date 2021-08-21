package dev.patika.patika0202.service;

import dev.patika.patika0202.dao.EmployeeDAO;
import dev.patika.patika0202.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements BaseService<Employee>{

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {

        return employeeDAO.save(employee);
    }

    @Override
    public void deleteById(int id) {

    }
}
