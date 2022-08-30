package com.springbootrestapi.springbootbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootrestapi.springbootbackend.exception.ResourceNotFoundException;
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

    @Override
    public Employee getEmployeeById(long id) {

        // Optional<Employee> employee=employeeRepository.findById(id);
        // if (employee.isPresent()) {
        //     return employee.get();
        // } else {
        //     throw new ResourceNotFoundException("Employee", "Id", id);
        // }
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }


    @Override
    public void deleteEmployee(long id) {

        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }

}
