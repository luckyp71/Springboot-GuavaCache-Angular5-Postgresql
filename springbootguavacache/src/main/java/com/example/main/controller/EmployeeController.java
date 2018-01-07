package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

import com.example.main.model.Employee;
import com.example.main.service.bean.EmployeeServiceBean;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeServiceBean empBean;
	
	@GetMapping(value="/clearCache", produces = MediaType.APPLICATION_JSON_VALUE)
	@Caching(evict = {
			@CacheEvict(value = "employee", allEntries = true),
			@CacheEvict(value = "employees", allEntries = true),
			@CacheEvict(value = "newEmployee", allEntries = true),
			@CacheEvict(value = "updatedEmployee", allEntries = true),
			@CacheEvict(value = "deletedEmployee", allEntries = true)
	})	
	public ResponseEntity<String> clearCache(){
		return ResponseEntity.accepted().body("{\"responseDesc\":\"cache is cleared successfully\"}");
	}
	
	
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployees() throws InterruptedException{
		Collection<Employee> employees = empBean.getEmployees();
		return ResponseEntity.accepted().body(employees);
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id")Long id) throws InterruptedException {
		Employee employee = empBean.getEmployee(id);
		return ResponseEntity.accepted().body(employee);
	}
	
	@PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) throws InterruptedException {
		String newEmployee = empBean.createEmployee(employee);
		return ResponseEntity.accepted().body(newEmployee);
		
	}
	
	@PutMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws InterruptedException {
		String newEmployee = empBean.updateEmployee(employee);
		return ResponseEntity.accepted().body(newEmployee);
	}
	
	@DeleteMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(Long id) throws InterruptedException {
		String deleteEmployee = empBean.deleteEmployee(id);
		return ResponseEntity.accepted().body(deleteEmployee);
	}
}
