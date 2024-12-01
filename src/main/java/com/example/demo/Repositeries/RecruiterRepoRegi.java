package com.example.demo.Repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RecruiterRegi;

public interface RecruiterRepoRegi extends JpaRepository<RecruiterRegi, Integer> {

	int countByEmail(String email);
	int countByMobile(Long mobile);
	RecruiterRegi findByMobile(long mobile);
	RecruiterRegi findByEmail(String email);

}
 