package com.example.demo.Repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dTO.StudentPersonalnfo;
import com.example.demo.entity.StudentRegister;

public interface StudentData extends JpaRepository<StudentRegister, Integer>{
	
}
 