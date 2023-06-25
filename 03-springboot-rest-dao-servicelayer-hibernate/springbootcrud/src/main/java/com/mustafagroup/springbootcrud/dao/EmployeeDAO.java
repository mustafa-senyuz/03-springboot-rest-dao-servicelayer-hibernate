package com.mustafagroup.springbootcrud.dao;

import java.util.List;

import com.mustafagroup.springbootcrud.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> getALLemployees();
	
	Employee findbyID(int id);
	
	Employee save(Employee newemployee);
	
	Employee updatebyID(int id);
	
	void deletebyID(int id);
	
}






