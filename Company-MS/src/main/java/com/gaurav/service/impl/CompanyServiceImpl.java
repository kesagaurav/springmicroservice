package com.gaurav.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.dto.CompanyDTO;
import com.gaurav.model.Company;
import com.gaurav.model.Company;
import com.gaurav.repository.CompanyRepository;
import com.gaurav.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository eRepo;

	@Override
	public CompanyDTO saveCompany(CompanyDTO edto) {
		// TODO Auto-generated method stub
		Company c = edto.createCompany();
		CompanyDTO c1 = edto.valueOf(c);
		eRepo.save(c);
		return c1;
	}

	@Override
	public List<CompanyDTO> getAllCompaniesDetails() {
		// TODO Auto-generated method stub
		List<Company> company = eRepo.findAll();
		List<CompanyDTO> cdto = new ArrayList<>();
		for (Company company1 : company) {
			CompanyDTO cdto1 = CompanyDTO.valueOf(company1);
			cdto.add(cdto1);
		}
		System.out.println("\n details are " + cdto);
		return cdto;
	}

	@Override
	public CompanyDTO getById(int id) {
//		CompanyDTO edto = null;
//		Optional<Company> e = eRepo.findById(id);
//		if (e.isPresent()) {
//			edto = CompanyDTO.valueOf(e.get());
//		}
//
//		return edto;
		//this is for using resilence 4j
//		if(id==2) {
//			throw new RuntimeException();
//		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CompanyDTO.valueOf(eRepo.findById(id).get());
	}
}
