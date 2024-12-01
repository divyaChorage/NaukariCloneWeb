package com.example.demo.studentLoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositeries.StudentRepoRegi;
import com.example.demo.dTO.StudentPersonalnfo;
import com.example.demo.entity.StudentRegister;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {

    @Autowired 
    StudentRepoRegi studentRepoRegi;

    @PostMapping("personalInfo")
    public int personalInfo(@RequestBody StudentPersonalnfo studentDto) {
        // Find student by mobile number
        StudentRegister existingStudent = studentRepoRegi.findByMobile(studentDto.getMobileNumber());

        if (existingStudent != null) {
            // Update existing record
            mapDtoToEntity(studentDto, existingStudent);
            studentRepoRegi.save(existingStudent);
            return 1; // Successfully updated
        } else {
            // Create new record
            StudentRegister newStudent = new StudentRegister();
            mapDtoToEntity(studentDto, newStudent);
            studentRepoRegi.save(newStudent);
            return 1; // Successfully saved
        }
    }

    // Utility method to map DTO fields to Entity
    private void mapDtoToEntity(StudentPersonalnfo dto, StudentRegister entity) {
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());
        entity.setAadharCardNumber(dto.getAadharCardNumber());
        entity.setTenthPercentage(dto.getTenthPercentage());
        entity.setTenthYear(dto.getTenthYear());
        entity.setTwelfthPercentage(dto.getTwelfthPercentage());
        entity.setTwelfthYear(dto.getTwelfthYear());
        entity.setGraduationYear(dto.getGraduationYear());
        
        // Set a default if graduation percentage is null
     

        entity.setGraduationStream(dto.getGraduationStream());
        entity.setGraduationCollegeName(dto.getGraduationCollegeName());
        entity.setGraduationUniversityName(dto.getGraduationUniversityName());
        entity.setPostGraduationYear(dto.getPostGraduationYear());
        entity.setPostGraduationPercentage(dto.getPostGraduationPercentage());
        entity.setPostGraduationStream(dto.getPostGraduationStream());
        entity.setPostGraduationCollegeName(dto.getPostGraduationCollegeName());
        entity.setPostGraduationUniversityName(dto.getPostGraduationUniversityName());
        entity.setHighestEducation(dto.getHighestEducation());
        entity.setHighestEducationYear(dto.getHighestEducationYear());
        entity.setHighestEducationLastYearPercentage(dto.getHighestEducationLastYearPercentage());
        entity.setHighestEducationAggregatePercentage(dto.getHighestEducationAggregatePercentage());
        entity.setYearGapInEducation(dto.getYearGapInEducation());
        entity.setLiveBacklog(dto.getLiveBacklog());
    }

}
