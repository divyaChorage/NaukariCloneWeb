package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class CompanyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

     int recruiterId;
     String companyName;
     String position;
     int noOfVacancies;
     List<String> skillsRequired;
     String experience;
     boolean bond; // Using boolean for yes/no
     String salary;
     int passoutYear;
     Date applicationDeadline;

     
    public CompanyData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyData(int id, int recruiterId, String companyName, String position, int noOfVacancies,
			List<String> skillsRequired, String experience, boolean bond, String salary, int passoutYear,
			Date applicationDeadline) {
		super();
		this.id = id;
		this.recruiterId = recruiterId;
		this.companyName = companyName;
		this.position = position;
		this.noOfVacancies = noOfVacancies;
		this.skillsRequired = skillsRequired;
		this.experience = experience;
		this.bond = bond;
		this.salary = salary;
		this.passoutYear = passoutYear;
		this.applicationDeadline = applicationDeadline;
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNoOfVacancies() {
        return noOfVacancies;
    }

    public void setNoOfVacancies(int noOfVacancies) {
        this.noOfVacancies = noOfVacancies;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public boolean isBond() {
        return bond;
    }

    public void setBond(boolean bond) {
        this.bond = bond;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getPassoutYear() {
        return passoutYear;
    }

    public void setPassoutYear(int passoutYear) {
        this.passoutYear = passoutYear;
    }

    public Date getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(Date applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "CompanyData{" +
                "id=" + id +
                ", recruiterId=" + recruiterId +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", noOfVacancies=" + noOfVacancies +
                ", skillsRequired=" + skillsRequired +
                ", experience='" + experience + '\'' +
                ", bond=" + bond +
                ", salary='" + salary + '\'' +
                ", passoutYear=" + passoutYear +
                ", applicationDeadline=" + applicationDeadline +
                '}';
    }
}
