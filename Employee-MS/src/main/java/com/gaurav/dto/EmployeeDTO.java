package com.gaurav.dto;

import com.gaurav.model.Employee;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EmployeeDTO {
	
	public int eid;

	private String name;

	private String location;

	private int age;

	private char gender;

	
	CompanyDTO cdto;

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "EmployeeDTO [eid=" + eid + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", location=" + location+ "]";
	}

	// converts entity into dto
	public static EmployeeDTO valueOf(Employee e) {
		EmployeeDTO edto = new EmployeeDTO();
		edto.setEid(e.getEid());
		edto.setName(e.getName());
		edto.setAge(e.getAge());
		edto.setGender(e.getGender());
		edto.setLocation(e.getLocation());
		CompanyDTO cdto = new CompanyDTO();
		cdto.setCid(e.getCid());
		return edto;
	}
	//converts dto into entity
	public Employee createEmployee() {
		Employee e = new Employee();
		e.setEid(this.eid);
		e.setName(this.getName());
		e.setGender(this.getGender());
		e.setLocation(this.getLocation());
		e.setAge(this.getAge());
		//e.setCid(this.getCdto().cid);
		return e;
	}

}
