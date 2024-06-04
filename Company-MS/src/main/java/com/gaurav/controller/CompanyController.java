package com.gaurav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService cs;
	@PostMapping("/Company")
	public  CompanyDTO saveCompany(@RequestBody CompanyDTO cdto) {
		// TODO Auto-generated method stub
		
		return cs.saveCompany(cdto);
	}
	@GetMapping("/companies")
	public List<CompanyDTO> getAllCompanyDetails(){
		return cs.getAllCompaniesDetails();
	}
	
	@GetMapping("/company/{id}")
	public CompanyDTO getById(@PathVariable int id) {
		return cs.getById(id);
	}
}
