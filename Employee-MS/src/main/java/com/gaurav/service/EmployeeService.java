package com.gaurav.service;

import com.gaurav.dto.EmployeeDTO;

public interface EmployeeService {

	public void saveEmployee(EmployeeDTO edto);
	public EmployeeDTO getById(int id);
}
