package com.example.demo.Repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StudentRegister;

public interface StudentRepoRegi extends JpaRepository<StudentRegister, Integer> {

	int countByEmail(String email);
	int countByMobile(Long mobile);
	StudentRegister findByMobile(long mobile);
	StudentRegister findByEmail(String email);
 
}
