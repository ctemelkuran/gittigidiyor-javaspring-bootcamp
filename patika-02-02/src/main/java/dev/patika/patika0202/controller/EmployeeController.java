package dev.patika.patika0202.controller;

import dev.patika.patika0202.dao.EmployeeDAO;
import dev.patika.patika0202.model.Employee;
import dev.patika.patika0202.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    EmployeeService employeeService; //Bunu inject etmeliyiz
    // Field injection @Autowired kullanır
    // Contructor injection en iyisi, testability

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

}
