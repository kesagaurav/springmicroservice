//package com.gaurav.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gaurav.dto.EmployeeDTO;
//import com.gaurav.service.EmployeeService;
//
//@RestController
//public class EmployeeController{
//	@Autowired
//	private EmployeeService es;
//	@PostMapping("/employee")
//	public  EmployeeDTO saveEmployee(@RequestBody EmployeeDTO edto) {
//		// TODO Auto-generated method stub
//		
//		return es.saveEmployee(edto);
//	}
//
//}
