package com.jspr.springBootBasic.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspr.springBootBasic.Dao.EmployeeDao;
import com.jspr.springBootBasic.Dto.EmployeeDto;
import com.jspr.springBootBasic.Dto.ResponceStructure;

@RestController
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	
//	@GetMapping("/create")
//	public String hello() {
//		return "sample";
//	}
	
	@PostMapping("/insertAll")
	public List<EmployeeDto> insert(@RequestBody List<EmployeeDto> dto) {
		return dao.insert(dto);
		
	}
	
	@PostMapping("/insert")
	public EmployeeDto insertOne(@RequestBody EmployeeDto dto) {
		EmployeeDto e=dao.insertOne(dto);
		return e;
	}
	
	@GetMapping("/fetch")
	public ResponceStructure fetchId(@RequestBody EmployeeDto dto){
		int eid=dto.getId();
		
		return dao.fetchId(eid);
	}
	
	@GetMapping("/fetchall")
	public List<EmployeeDto> fetchAll(){
		List<EmployeeDto> e=dao.fetchAll();
		return e;
	}
	
	//postman url : http:localhost:8081/employees/delete/1
	@DeleteMapping("/delete/{id}")
	public String deleteId(@PathVariable int id) {
		dao.deleteId(id);
		return "data deleted";
	}
	
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		dao.deleteAll();
	}
	
	//http:localhost:8081/employees/update?id=1
	@PutMapping("/update")
	public void updateId(@RequestParam int id) {
		//dao.updateId(id);
		System.out.println(id);
		
	}

}
