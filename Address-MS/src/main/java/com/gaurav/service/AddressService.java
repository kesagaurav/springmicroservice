package com.gaurav.service;

import java.util.List;

import com.gaurav.dto.AddressDTO;

public interface AddressService {

	public void saveAddress(AddressDTO edto);
	public List<Integer> getByPincode(Integer pinoode);
}
