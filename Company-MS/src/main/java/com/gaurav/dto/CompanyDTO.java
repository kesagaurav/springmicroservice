package com.gaurav.dto;

import com.gaurav.model.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyDTO {

	public Integer cid;
	public String companyName;
	
	 //converts entity into dto
		public static CompanyDTO valueOf(Company e) {
		
			CompanyDTO cdto = new CompanyDTO();
			cdto.setCid(e.getCid());
			cdto.setCompanyName(e.getName());
			return cdto;
		}
	
		public Company createCompany() {
			Company c = new Company();
			c.setCid(this.cid);
			c.setName(this.companyName);
			return c;
		}
		
	
}
