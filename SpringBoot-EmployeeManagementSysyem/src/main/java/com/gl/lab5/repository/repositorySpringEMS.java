package com.gl.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.lab5.model.Employee;

@Repository
public interface repositorySpringEMS extends JpaRepository<Employee, Integer> {

}
