package com.gaurav.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaurav.dto.AddressDTO;
import com.gaurav.model.Address;
import com.gaurav.repository.AddressRepository;
import com.gaurav.repository.AddressRepository;
import com.gaurav.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository eRepo;

	@Override
	public void saveAddress(AddressDTO edto) {
		// TODO Auto-generated method stub
		Address e = edto.createAddress();
		eRepo.save(e);

	}

	@Override
	public List<Integer> getByPincode(Integer pincode) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		List<Address> adList=eRepo.getByPincode(pincode);
		for (Address address : adList) {
			list.add(address.getPincode());
		}
		return list;
	}

	

//	@Override
//	public AddressDTO getById(int id) {
//		// TODO Auto-generated method stub
//		Address e = eRepo.findById(id).get();
//		AddressDTO edto=AddressDTO.valueOf(e);
//		
//		return edto;
//	}

}
