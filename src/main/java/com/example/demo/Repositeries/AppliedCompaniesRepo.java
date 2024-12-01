package com.example.demo.Repositeries;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.AppliedCompanies;
import com.example.demo.entity.CompanyData;
import com.example.demo.projection.AppliedStudentForCompany;
import com.example.demo.projection.ViewAppliedCompanies;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public interface AppliedCompaniesRepo extends JpaRepository<AppliedCompanies, Integer> {

	
			
			
@Query("SELECT s.name AS studentName, a.resumePath AS resumePath, s.email AS email, s.mobile AS mobile " +
	           "FROM AppliedCompanies a " +
	           "JOIN StudentRegister s ON a.userId = s.id " +
	           "WHERE a.companyId = :companyId")
	    List<AppliedStudentForCompany> getAllStudentsWithDetailsByCompanyId(@Param("companyId") int companyId);


@Query("SELECT a.companyName AS companyName, c.experience AS experience, c.noOfVacancies AS noOfVacancies, c.position AS position, c.salary AS salary " +
	       "FROM AppliedCompanies a JOIN CompanyData c ON a.companyId = c.id WHERE a.userId = :userId")
	List<ViewAppliedCompanies> getAllAppliedCompanies(@Param("userId") int userId);




}