package com.example.main.service.bean;

import java.util.Collection;

import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.example.main.model.Employee;
import com.example.main.repository.EmployeeRepository;
import com.example.main.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceBean implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	private final String responseSuccess = "{\"responseDesc\":\"success\"}";
	private final String objNotFound = "{\"responseDesc\":\"object not found\"}";
	private final String dataAlreadyExists = "{\"responseDesc\":\"data with given id already exists\"}";

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	@Cacheable("employees")
	public Collection<Employee> getEmployees() throws InterruptedException {
		log.info("Start getting list of employees");		
		Thread.sleep(5000);
		
		Collection<Employee> employees = empRepo.findAll();
		log.info("Return list of employees");
		return employees;
	}

	@Override
	@Cacheable("employee")
	public Employee getEmployee(Long id) throws InterruptedException {
		Employee employee = empRepo.findOne(id);
		log.info("Start getting single object of employee");
		Thread.sleep(5000);
		log.info("Return Employee");
		return employee;
	}

	@Override
	@Cacheable("newEmployee")
	public String createEmployee(Employee employee) throws InterruptedException{
		Employee employeePersisted = getEmployee(employee.getId());
		log.info("Start creating a new employee");
		Thread.sleep(5000);
		
		if (employeePersisted != null) {
			log.warn("Data already exists");
			return dataAlreadyExists;
		} else {
			empRepo.save(employee);
			log.info("New employee recorded");
			return responseSuccess;
		}
	}

	@Override
	@Cacheable("updatedEmployee")
	public String updateEmployee(Employee employee) throws InterruptedException {
		Employee employeePersisted = getEmployee(employee.getId());
		log.info("Start updating an employee");
		Thread.sleep(5000);
		
		if (employeePersisted == null) {
			log.warn("Employee with given id not found");
			return objNotFound;
		} else {
			empRepo.save(employee);
			log.info("Employee updated");
			return responseSuccess;
		}
	}

	@Override
	@Cacheable("deletedEmployee")
	public String deleteEmployee(Long id) throws InterruptedException {
		Employee employeePersisted = empRepo.findOne(id);
		log.info("Start deleting employee");
		Thread.sleep(5000);

		if (employeePersisted == null) {
			log.warn("Employee with given object not found");
			return objNotFound;
		} else {
			empRepo.delete(id);
			log.info("Employee deleted");
			return responseSuccess;
		}
	}
}
