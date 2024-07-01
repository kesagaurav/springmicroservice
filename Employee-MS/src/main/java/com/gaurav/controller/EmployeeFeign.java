package com.gaurav.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaurav.dto.CompanyDTO;

@FeignClient(name="CompanyMS",url="http://localhost:9000/")
public interface EmployeeFeign {
	@RequestMapping("/plans/{planId}")
	CompanyDTO cdto(@PathVariable int cid);
		
	
}
