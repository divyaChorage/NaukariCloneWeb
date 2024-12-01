package com.example.demo.studentLoginController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repositeries.AppliedCompaniesRepo;
import com.example.demo.Repositeries.CompanyRepo;
import com.example.demo.entity.AppliedCompanies;
import com.example.demo.entity.CompanyData;
import com.example.demo.entity.RecruiterRegi;
import com.example.demo.projection.ViewAppliedCompanies;


@CrossOrigin(origins = "http://localhost:4200")
@RestController  
public class CompanyApplyByStudentController {

	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	AppliedCompaniesRepo appliedCompaniesRepo;
	  
    @RequestMapping("getAllComapnies")
    public  List<CompanyData> getAllComa() {
    
    	 List<CompanyData> list= companyRepo.getAllComapanies();
    System.out.println(list);
    	 return list;
    }
    
    
    @PostMapping("applyForCompany/{userId}")
    public int applyForCompany(
            @PathVariable int userId,
            @RequestParam("companyId") int companyId,
            @RequestParam("companyName") String companyName,
            @RequestParam("recruiterId") int recruiterId,
            @RequestParam("resume") MultipartFile resume) {


        if (resume.isEmpty()) {
            return -1;// ResponseEntity.badRequest().body("Resume file is missing!");
        }

        try {
        	
        	 String resumeDirectory = "D:\\NoukariApp\\resumes\\";

        	 

        	        // Ensure the directory exists
        	        File directory = new File(resumeDirectory);
        	        if (!directory.exists()) {
        	            directory.mkdirs();
        	        }

        	        // Get the original file name
        	        String fileName = resume.getOriginalFilename();
        	        Path filePath = Paths.get(resumeDirectory, fileName);

        	        // Check if the file already exists
        	        if (Files.exists(filePath)) {
        	            // If the file exists, generate a unique name using userId or timestamp
        	            String uniqueFileName = userId + "_" + System.currentTimeMillis() + "_" + fileName;
        	            filePath = Paths.get(resumeDirectory, uniqueFileName);
        	        }

        	        // Copy the file to the desired location
        	        Files.copy(resume.getInputStream(), filePath);

            
            AppliedCompanies appliedCompany = new AppliedCompanies();
            appliedCompany.setUserId(userId);
            appliedCompany.setCompanyId(companyId);
            appliedCompany.setCompanyName(companyName);
            appliedCompany.setRecruiterId(recruiterId);
            appliedCompany.setResumePath(fileName); // Assuming you have this field in your entity

            appliedCompaniesRepo.save(appliedCompany);

            return  1;// ResponseEntity.ok("Application submitted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return   0;//ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while submitting the application.");
        }
        
   
    }
    
    @GetMapping("viewAppliedCompanies/{userId}")
    public List<ViewAppliedCompanies> viewAppliedCompanies(@PathVariable int userId) {
        List<ViewAppliedCompanies> list = appliedCompaniesRepo.getAllAppliedCompanies(userId);

        // Printing the output for debugging
        for(ViewAppliedCompanies company : list) {
            System.out.println("apply---" + company.getCompanyName());
        }
        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        return list;
    }


	
}
