package com.gaurav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaurav.config.LoadBalancerConfig;
import com.gaurav.dto.CompanyDTO;
import com.gaurav.dto.EmployeeDTO;
import com.gaurav.service.EmployeeService;

@RestController
@LoadBalancerClient(name="MyloadBalancer", configuration=LoadBalancerConfig.class)
public class EmployeeController {
	@Autowired
	private EmployeeService es;
	
	String companyUri;
	// to implement service discovery we should add discovery client
	@Autowired
	private DiscoveryClient client;
	@Autowired
	RestTemplate template;

	@PostMapping("/employee")
	public void saveEmployee(@RequestBody EmployeeDTO edto) {
		// TODO Auto-generated method stub

		es.saveEmployee(edto);
	}

	@GetMapping("/employee/{id}")
	public EmployeeDTO getById(@PathVariable int id) {
		EmployeeDTO edto = es.getById(id);
		// before using service discovery
//		CompanyDTO cdto=new RestTemplate().getForObject("http://localhost:9091/company/2",CompanyDTO.class);
		// After using service discovery
		List<ServiceInstance> listOfCompanyInstances = client.getInstances("Company-MS");
		if (listOfCompanyInstances != null && !listOfCompanyInstances.isEmpty())
			companyUri = listOfCompanyInstances.get(0).getUri().toString();
		CompanyDTO cdto = new RestTemplate().getForObject(companyUri +"/company/2", CompanyDTO.class);
		//using static load balencer.
		//CompanyDTO cdto = new RestTemplate().getForObject("http://MyloadBalancer/company/"+2, CompanyDTO.class);
		//using cloud consul
		//CompanyDTO cdto = template.getForObject("http://Company-MS/2", CompanyDTO.class);

		edto.setCdto(cdto);
		return edto;
	}

}
