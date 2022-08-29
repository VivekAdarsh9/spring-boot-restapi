package com.springbootrestapi.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity                                         //specifies that class is an entity
@Table(name="employees")                        //if we don't provide @Table annotation then JPA will crete table with name as Class name(Employee)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="Last_name")
    private String lastName;

    @Column(name="email")
    private String email;
}
