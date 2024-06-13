package com.gaurav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gaurav.dto.CompanyDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.vavr.concurrent.Future;
//synchorous communication 
@Service
public class EmpCircuitBreakerService {
	String companyUri;
	@Autowired
	RestTemplate template;
	//using by synchronous communication
//	@CircuitBreaker(name="employeeService")
//	public CompanyDTO getByCompanyId(int id) {
//		//using by load balancer
//		//return template.getForObject("http://Company-MS"+"/plans/"+id,CompanyDTO.class);
//		return template.getForObject(companyUri +"/company/1", CompanyDTO.class);
//	}
	//using asynchronous communication using future so it can run independnetly
	@CircuitBreaker(name="employeeService")
	public Future<CompanyDTO> getByCompanyId(int id) {
		
		return Future.of(()->template.getForObject(companyUri +"/company/1", CompanyDTO.class));
	}
}
