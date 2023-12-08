package com.jspr.springBootBasic.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jspr.springBootBasic.Dto.EmployeeDto;
import com.jspr.springBootBasic.Dto.ResponceStructure;
import com.jspr.springBootBasic.repository.EmployeeRepository;

@Component
public class EmployeeDao {
	@Autowired
	EmployeeRepository repository;

	public List<EmployeeDto> insert(List<EmployeeDto> dto) {

		return repository.saveAll(dto);
	}

	public EmployeeDto insertOne(EmployeeDto dto) {
		EmployeeDto e1 = repository.save(dto);
		return e1;
	}

	public ResponceStructure fetchId(int id) {
		Optional<EmployeeDto> dto = repository.findById(id);
		if(dto.isEmpty()) {
		ResponceStructure structure = new ResponceStructure();
		structure.setMeesage("Data not found");
		//using Enum Httpstatus
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(null);
		return structure;
		}else {
			ResponceStructure structure = new ResponceStructure();
			structure.setMeesage("Data found success");
			//using Enum Httpstatus
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto.get());
			return structure;
		}
	
	}

	public List<EmployeeDto> fetchAll() {
		List<EmployeeDto> dto = repository.findAll();
		return dto;
	}

	public ResponseEntity<String> deleteId(int id) {
		Optional<EmployeeDto> od=repository.findById(id);
		od.get();
		if(od.isEmpty()) {
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}else {
		repository.deleteById(id);
		return new ResponseEntity<String>("data deleted successfully", HttpStatus.ACCEPTED);
		}
	}
	
	

	public String deleteAll() {
		List<EmployeeDto> list=repository.findAll();
		if(list.isEmpty()) {
			
		}
		repository.deleteAll();
		return "All data deleted";
	}

	public EmployeeDto updateId(EmployeeDto dto) {
		repository.save(dto);
		return dto;

	}
}
