package com.springbootrestapi.springbootbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootrestapi.springbootbackend.model.Employee;
import com.springbootrestapi.springbootbackend.repository.EmployeeRepository;
import com.springbootrestapi.springbootbackend.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;


     //Constructor Injection
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

}
