package com.gaurav.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaurav.dto.EmployeeDTO;
import com.gaurav.model.Employee;
import com.gaurav.repository.EmployeeRepository;
import com.gaurav.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository eRepo;

	@Override
	public void saveEmployee(EmployeeDTO edto) {
		// TODO Auto-generated method stub
		Employee e = edto.createEmployee();
		eRepo.save(e);

	}

	@Override
	public EmployeeDTO getById(int id) {
		// TODO Auto-generated method stub
		Employee e = eRepo.findById(id).get();
		EmployeeDTO edto=EmployeeDTO.valueOf(e);
		
		return edto;
	}

}
