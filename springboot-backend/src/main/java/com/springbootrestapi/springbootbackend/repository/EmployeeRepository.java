package com.springbootrestapi.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapi.springbootbackend.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {



}
