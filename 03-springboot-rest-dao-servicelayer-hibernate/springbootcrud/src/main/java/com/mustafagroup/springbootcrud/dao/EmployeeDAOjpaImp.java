package com.mustafagroup.springbootcrud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mustafagroup.springbootcrud.entity.Employee;
import com.mustafagroup.springbootcrud.service.EmployeeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;



@Repository
public class EmployeeDAOjpaImp implements EmployeeDAO{
	
	
	private EntityManager em;			//  DB işlemleri için gerekli jpa

	public EmployeeDAOjpaImp(EntityManager entitymanager) {
		super();
		this.em = entitymanager;
	}


	@Override
	public List<Employee> getALLemployees() {
		
		TypedQuery<Employee> myQuery = em.createQuery("from Employee" , Employee.class);
		
		List<Employee> employeelist = myQuery.getResultList();
 
		return employeelist;
	}


	@Override
	public Employee findbyID(int id) {
		
		   Employee wantedemployee = em.find(Employee.class, id);
		   
		     return wantedemployee;
	}


	@Override
	public Employee save(Employee newemployee) {
 
		 Employee employeetosave = em.merge(newemployee);  // yeni eklenmek istiyorsa id 0 ayarlanir
		
		 return employeetosave;
		
	}
	
	
	@Override
	public Employee updatebyID(int id) {
		
		Employee renewEmployee = em.find(Employee.class , id);
		
		em.merge(renewEmployee);
 
		return renewEmployee;
	}
	


	@Override
	public void deletebyID(int id) {
 
		Employee  employeetoremove = em.find(Employee.class , id);
		
		em.remove(employeetoremove);
		
	}



}
