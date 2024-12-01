package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AppliedCompanies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

     int userId;
     int companyId;
     String companyName;
     int recruiterId;

    // Storing the file path as a string
     String resumePath;

    // Default constructor
    public AppliedCompanies() {
    }
    
    

    public AppliedCompanies(int id, int userId, int companyId, String companyName, int recruiterId, String resumePath) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyId = companyId;
		this.companyName = companyName;
		this.recruiterId = recruiterId;
		this.resumePath = resumePath;
	}



	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

	@Override
	public String toString() {
		return "AppliedCompanies [id=" + id + ", userId=" + userId + ", companyId=" + companyId + ", companyName="
				+ companyName + ", recruiterId=" + recruiterId + ", resumePath=" + resumePath + "]";
	}
    
    
}
