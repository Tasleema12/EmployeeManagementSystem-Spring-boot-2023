package com.jspr.springBootBasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspr.springBootBasic.Dto.EmployeeDto;

public interface EmployeeRepository extends JpaRepository<EmployeeDto, Integer>{

}
