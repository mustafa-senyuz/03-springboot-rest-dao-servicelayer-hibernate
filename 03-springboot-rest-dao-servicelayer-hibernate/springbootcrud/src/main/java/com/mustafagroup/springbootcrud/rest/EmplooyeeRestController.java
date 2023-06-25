package com.mustafagroup.springbootcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafagroup.springbootcrud.dao.EmployeeDAO;
import com.mustafagroup.springbootcrud.entity.Employee;
import com.mustafagroup.springbootcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmplooyeeRestController {
	
	private EmployeeService es;

	@Autowired
	public EmplooyeeRestController(EmployeeService employserv) { // empDAO.getALLemployees(); -> normalde main() class içerisinde görmeye alisigiz
 
		 es = employserv;
	}
	
	@GetMapping("/employees")
	public List<Employee> getALLemployees(){
		
		return es.getALLemployees();			// POJO to JSON   otomatik çevirme
	}
	
	

	@GetMapping("/employees/{id}")
	public Employee findbyID(@PathVariable int id) {
				
		if( es.findbyID(id) == null) {throw new RuntimeException("the employee is not found by " + id + " id ");}
		
		return es.findbyID(id);
	}
	
	
	@PostMapping("/employees")
	public Employee addnewEmployee(@RequestBody Employee newemployee) {
		
		//set id  0 to add instead of put daha önce bu id de obj yok ...
		newemployee.setId(0);
		
		return es.save(newemployee);
	}
	
	
	@PutMapping("/employees")
	public Employee updatEmployee(@RequestBody Employee renewemployee) {
		
		return es.save(renewemployee);  //üst üste kayıt update tir
	}
	
	
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		es.deletebyID(id);
		
		return  "this employee deleted with id " + id ;
	}
	
	

}