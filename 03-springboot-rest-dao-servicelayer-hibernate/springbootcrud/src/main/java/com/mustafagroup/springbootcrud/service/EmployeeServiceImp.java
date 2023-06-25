package com.mustafagroup.springbootcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mustafagroup.springbootcrud.dao.EmployeeDAO;
import com.mustafagroup.springbootcrud.entity.Employee;

import jakarta.transaction.Transactional;

// İŞİ YAPTIRAN !!! (DAO obj. e)

@Service
public class EmployeeServiceImp implements EmployeeService {	//daha önceki main() metodundaki interfaceOBJ yani DAO dan metod cagrisi yapiyor
 	
	private EmployeeDAO eDAO;
	

	public EmployeeServiceImp(EmployeeDAO emploDAO) {

		 eDAO = emploDAO;
	}


	@Override
	public List<Employee> getALLemployees() {	//metodu callback
		return eDAO.getALLemployees();
	}


	@Override
	public Employee findbyID(int id) {
 		
		return eDAO.findbyID(id);
	}


	@Override
	@Transactional
	public Employee save(Employee newemployee) {
 
		return eDAO.save(newemployee);
		
	}


	@Override
	@Transactional
	public void deletebyID(int id) {
 
		eDAO.deletebyID(id);
		
	}


	@Override
	@Transactional
	public Employee updatebyID(int id) {
		
		Employee newEmployee =  eDAO.updatebyID(id);
		
		return newEmployee;
	}


	
	
	
	
	
	
	
}
