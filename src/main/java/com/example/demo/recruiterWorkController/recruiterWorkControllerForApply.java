package com.example.demo.recruiterWorkController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositeries.AppliedCompaniesRepo;
import com.example.demo.Repositeries.CompanyRepo;
import com.example.demo.entity.CompanyData;
import com.example.demo.projection.AppliedStudentForCompany;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "http://localhost:4200")
@RestController  
public class recruiterWorkControllerForApply {

	
	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	AppliedCompaniesRepo appliedCompaniesRepo;
	
	@PostMapping("addCompany/{id}")
	public ResponseEntity<String> addingCompany(@RequestBody CompanyData companyData, @PathVariable int id) {
	    if (companyData == null) {
	        return ResponseEntity.badRequest().body("Invalid data: companyData is null");
	    }

	    // Set recruiterId from path variable
	    companyData.setRecruiterId(id);

	    // Save companyData to the database
	    CompanyData savedCompany = companyRepo.save(companyData);

	    // Log the saved entity
	    System.out.println("Saved Company: " + savedCompany);

	    // Return a success response
	    return ResponseEntity.ok("Company added successfully");
	}

	
	
	
	  
    @RequestMapping("getAllComapnies/{recruiterId}")
    public  List<CompanyData> getAllComa(@PathVariable int recruiterId ) {
    
    	 List<CompanyData> list= companyRepo.getAllCompaniesByRecruiterId(recruiterId);
    System.out.println(list);
    	 return list;
    }
	
	
    
    @GetMapping("getAllStudentsAppliedForCompany/{companyId}")
    public List<AppliedStudentForCompany> getAllStudents(@PathVariable int companyId) {
        return appliedCompaniesRepo.getAllStudentsWithDetailsByCompanyId(companyId);
    }
    
    
    
    
  

    // Download resume by file name
    @GetMapping("downloadResume/{fileName}")
    public ResponseEntity<Resource> downloadResume(@PathVariable String fileName) {
        try {
            // Define the directory where resumes are stored
            String resumeDirectory = "D:\\NoukariAPp\\resumes\\"; // Adjust this path as needed

            // Resolve the file path
            Path filePath = Paths.get(resumeDirectory).resolve(fileName).normalize();

            // Log the file path for debugging
            System.out.println("Looking for file at: " + filePath.toString());

            // Create a Resource object for the file
            Resource resource = new UrlResource(filePath.toUri());

            // Check if the file exists
            if (!resource.exists()) {
                System.out.println("File not found: " + filePath.toString());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            // Return the file as an attachment
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);

        } catch (Exception e) {
            // Handle any errors during file processing
            System.err.println("Error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    
 

	
	//add company data
}
