package com.jspr.springBootBasic.Dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class EmployeeDto {
	private String ename;
	@Id
	private int id;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "EmployeeDto [ename=" + ename + ", id=" + id + "]";
	}
	
	

}
