package com.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
