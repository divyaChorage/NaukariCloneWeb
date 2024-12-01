package com.example.demo.Repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CompanyData;

public interface CompanyRepo extends JpaRepository<CompanyData, Integer> {

	  @Query(value = "SELECT * FROM  company_data", nativeQuery = true)
	List<CompanyData> getAllComapanies();
	  
	  
		@Query(value = "SELECT * FROM company_data where recruiter_id = :recruiterId", nativeQuery = true)
		List<CompanyData> getAllCompaniesByRecruiterId(@Param("recruiterId") int recruiterId);

}

