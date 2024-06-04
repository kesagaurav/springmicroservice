package com.gaurav.service;

import java.util.List;

import com.gaurav.dto.CompanyDTO;

public interface CompanyService {

	public CompanyDTO saveCompany(CompanyDTO edto);
	public List<CompanyDTO> getAllCompaniesDetails();
	public CompanyDTO getById(int id);
}
