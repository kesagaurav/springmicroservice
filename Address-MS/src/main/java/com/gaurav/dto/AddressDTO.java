package com.gaurav.dto;

import com.gaurav.model.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
	 int aid;

	 String state;

	 String country;

	 int pincode;
	 
	 public static AddressDTO valueOf(Address add) {
		 AddressDTO adto=new AddressDTO();
		 adto.setAid(add.getAid());
		 adto.setState(add.getState());
		 adto.setCountry(add.getCountry());
		 adto.setPincode(add.getPincode());
		 return adto;
	 }
	 
	 public Address createAddress() {
		 Address add=new Address();
		 add.setAid(this.getAid());
		 add.setCountry(this.getCountry());
		 add.setPincode(this.getPincode());
		 add.setState(this.getState());
		 return add;
	 }
}
