package com.gaurav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.dto.EmployeeDTO;
import com.gaurav.service.EmployeeService;

@RestController
public class EmployeeController{
	@Autowired
	private EmployeeService es;
	@PostMapping("/employee")
	public  void saveEmployee(@RequestBody EmployeeDTO edto) {
		// TODO Auto-generated method stub
		
		 es.saveEmployee(edto);
	}
	@GetMapping("/employee/{id}")
	public EmployeeDTO getById(@PathVariable int id) {
		EmployeeDTO edto= es.getById(id);
		CompanyDTO cdto=new RestTemplate().getForObject("http://localhost:9091/company/2",CompanyDTO.class);
		edto.setCdto(cdto);
		return edto;
	}

}
