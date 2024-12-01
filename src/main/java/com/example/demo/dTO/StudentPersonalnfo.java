package com.example.demo.dTO;

import com.example.demo.entity.StudentRegister;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class StudentPersonalnfo {

	 Long mobileNumber;
     String address;
     String gender;
     String aadharCardNumber;
     double tenthPercentage;
     int tenthYear;
     double twelfthPercentage;
     int twelfthYear;
     int graduationYear;
    
     String graduationStream;
     String graduationCollegeName;
     String graduationUniversityName;
     int postGraduationYear;
     double postGraduationPercentage;
     String postGraduationStream;
     String postGraduationCollegeName;
     String postGraduationUniversityName;
     String highestEducation;
     int highestEducationYear;
     double highestEducationLastYearPercentage;
     double highestEducationAggregatePercentage;
     int yearGapInEducation;
     int liveBacklog;
	public StudentPersonalnfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPersonalnfo(Long mobileNumber, String address, String gender, String aadharCardNumber,
			double tenthPercentage, int tenthYear, double twelfthPercentage, int twelfthYear, int graduationYear,
			 String graduationStream, String graduationCollegeName,
			String graduationUniversityName, int postGraduationYear, double postGraduationPercentage,
			String postGraduationStream, String postGraduationCollegeName, String postGraduationUniversityName,
			String highestEducation, int highestEducationYear, double highestEducationLastYearPercentage,
			double highestEducationAggregatePercentage, int yearGapInEducation, int liveBacklog) {
		super();
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.gender = gender;
		this.aadharCardNumber = aadharCardNumber;
		this.tenthPercentage = tenthPercentage;
		this.tenthYear = tenthYear;
		this.twelfthPercentage = twelfthPercentage;
		this.twelfthYear = twelfthYear;
		this.graduationYear = graduationYear;
		this.graduationStream = graduationStream;
		this.graduationCollegeName = graduationCollegeName;
		this.graduationUniversityName = graduationUniversityName;
		this.postGraduationYear = postGraduationYear;
		this.postGraduationPercentage = postGraduationPercentage;
		this.postGraduationStream = postGraduationStream;
		this.postGraduationCollegeName = postGraduationCollegeName;
		this.postGraduationUniversityName = postGraduationUniversityName;
		this.highestEducation = highestEducation;
		this.highestEducationYear = highestEducationYear;
		this.highestEducationLastYearPercentage = highestEducationLastYearPercentage;
		this.highestEducationAggregatePercentage = highestEducationAggregatePercentage;
		this.yearGapInEducation = yearGapInEducation;
		this.liveBacklog = liveBacklog;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAadharCardNumber() {
		return aadharCardNumber;
	}
	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}
	public double getTenthPercentage() {
		return tenthPercentage;
	}
	public void setTenthPercentage(double tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}
	public int getTenthYear() {
		return tenthYear;
	}
	public void setTenthYear(int tenthYear) {
		this.tenthYear = tenthYear;
	}
	public double getTwelfthPercentage() {
		return twelfthPercentage;
	}
	public void setTwelfthPercentage(double twelfthPercentage) {
		this.twelfthPercentage = twelfthPercentage;
	}
	public int getTwelfthYear() {
		return twelfthYear;
	}
	public void setTwelfthYear(int twelfthYear) {
		this.twelfthYear = twelfthYear;
	}
	public int getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getGraduationStream() {
		return graduationStream;
	} 
	public void setGraduationStream(String graduationStream) {
		this.graduationStream = graduationStream;
	}
	public String getGraduationCollegeName() {
		return graduationCollegeName;
	}
	public void setGraduationCollegeName(String graduationCollegeName) {
		this.graduationCollegeName = graduationCollegeName;
	}
	public String getGraduationUniversityName() {
		return graduationUniversityName;
	}
	public void setGraduationUniversityName(String graduationUniversityName) {
		this.graduationUniversityName = graduationUniversityName;
	}
	public int getPostGraduationYear() {
		return postGraduationYear;
	}
	public void setPostGraduationYear(int postGraduationYear) {
		this.postGraduationYear = postGraduationYear;
	}
	public double getPostGraduationPercentage() {
		return postGraduationPercentage;
	}
	public void setPostGraduationPercentage(double postGraduationPercentage) {
		this.postGraduationPercentage = postGraduationPercentage;
	}
	public String getPostGraduationStream() {
		return postGraduationStream;
	}
	public void setPostGraduationStream(String postGraduationStream) {
		this.postGraduationStream = postGraduationStream;
	}
	public String getPostGraduationCollegeName() {
		return postGraduationCollegeName;
	}
	public void setPostGraduationCollegeName(String postGraduationCollegeName) {
		this.postGraduationCollegeName = postGraduationCollegeName;
	}
	public String getPostGraduationUniversityName() {
		return postGraduationUniversityName;
	}
	public void setPostGraduationUniversityName(String postGraduationUniversityName) {
		this.postGraduationUniversityName = postGraduationUniversityName;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public int getHighestEducationYear() {
		return highestEducationYear;
	}
	public void setHighestEducationYear(int highestEducationYear) {
		this.highestEducationYear = highestEducationYear;
	}
	public double getHighestEducationLastYearPercentage() {
		return highestEducationLastYearPercentage;
	}
	public void setHighestEducationLastYearPercentage(double highestEducationLastYearPercentage) {
		this.highestEducationLastYearPercentage = highestEducationLastYearPercentage;
	}
	public double getHighestEducationAggregatePercentage() {
		return highestEducationAggregatePercentage;
	}
	public void setHighestEducationAggregatePercentage(double highestEducationAggregatePercentage) {
		this.highestEducationAggregatePercentage = highestEducationAggregatePercentage;
	}
	public int getYearGapInEducation() {
		return yearGapInEducation;
	}
	public void setYearGapInEducation(int yearGapInEducation) {
		this.yearGapInEducation = yearGapInEducation;
	}
	public int getLiveBacklog() {
		return liveBacklog;
	}
	public void setLiveBacklog(int liveBacklog) {
		this.liveBacklog = liveBacklog;
	}
	@Override
	public String toString() {
		return "StudentPersonalnfo [mobileNumber=" + mobileNumber + ", address=" + address + ", gender=" + gender
				+ ", aadharCardNumber=" + aadharCardNumber + ", tenthPercentage=" + tenthPercentage + ", tenthYear="
				+ tenthYear + ", twelfthPercentage=" + twelfthPercentage + ", twelfthYear=" + twelfthYear
				+ ", graduationYear=" + graduationYear 
				+ ", graduationStream=" + graduationStream + ", graduationCollegeName=" + graduationCollegeName
				+ ", graduationUniversityName=" + graduationUniversityName + ", postGraduationYear="
				+ postGraduationYear + ", postGraduationPercentage=" + postGraduationPercentage
				+ ", postGraduationStream=" + postGraduationStream + ", postGraduationCollegeName="
				+ postGraduationCollegeName + ", postGraduationUniversityName=" + postGraduationUniversityName
				+ ", highestEducation=" + highestEducation + ", highestEducationYear=" + highestEducationYear
				+ ", highestEducationLastYearPercentage=" + highestEducationLastYearPercentage
				+ ", highestEducationAggregatePercentage=" + highestEducationAggregatePercentage
				+ ", yearGapInEducation=" + yearGapInEducation + ", liveBacklog=" + liveBacklog + "]";
	}
	     
		
}
