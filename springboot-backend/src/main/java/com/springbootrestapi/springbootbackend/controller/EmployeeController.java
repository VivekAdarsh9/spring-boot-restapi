package com.springbootrestapi.springbootbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.springbootbackend.model.Employee;
import com.springbootrestapi.springbootbackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //Build Create Employee Rest API
    @PostMapping("/postEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get all employee Rest API
    @GetMapping("/getEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    //build get employee by Id Rest API
    // @GetMapping("/getEmployee/{id}")
    // public ResponseEntity<Employee> getEmployee(@PathVariable ("id")) {
    //     return employeeService.getAllEmployee();
    // }



}
