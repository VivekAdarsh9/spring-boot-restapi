package com.springbootrestapi.springbootbackend.service;

import java.util.List;

import com.springbootrestapi.springbootbackend.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);

}
