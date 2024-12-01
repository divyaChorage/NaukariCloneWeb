package com.example.demo.studentLoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositeries.StudentRepoRegi;
import com.example.demo.entity.StudentRegister;

import java.security.SecureRandom;

@CrossOrigin(origins = "http://localhost:4200")
@RestController  
public class StudentRegisterController {

    @Autowired
    StudentRepoRegi studentRepoRegi;
    
    @Autowired
    JavaMailSender mailSender;

    @PostMapping("StudentRegister")
    public int registrationStudent(@RequestBody StudentRegister stu) {
        // Check if email is null or empty
        if (stu.getEmail() == null || stu.getEmail().trim().isEmpty()) {
            return -1;  // Invalid email
        }

        // Check if name is null or empty
        if (stu.getName() == null || stu.getName().trim().isEmpty()) {
            return -2;  // Invalid name
        }

        // Check if mobile number is valid
        if (stu.getMobile() < 1111111111L || stu.getMobile() > 9999999999L) {
            return -3;  // Invalid mobile number
        }

        // Generate a random password
        String password = generateRandomPassword();
        stu.setPassword(password);  // Set the generated password as plain text

        // Send password to email
        sendPasswordToEmail(stu.getEmail(), password);

        // Save student to the database
        studentRepoRegi.save(stu);
        return 1;
    }

    // Method to generate a random password
    private String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        int length = 5; // Desired password length
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    // Method to send the generated password to the student's email
    private void sendPasswordToEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your Registration Password");
        message.setText("Your password is: " + password);
        mailSender.send(message);
    }

    @RequestMapping("loginStudent")
    public int loginStudent(@RequestBody String[] credentials) {
        String username = credentials[0];
        String passwordStr = credentials[1]; // No need to cast, already a String

        int type = checkType(username); // 1 for email, 2 for mobile
        StudentRegister student;

        if (type == 1) {
            student = getStudentByEmail(username);
            if (student == null) {
                return -1; // Email not found
            }
        } else {
            try {
                Long mobile = Long.parseLong(username);
                student = getStudentByMobile(mobile);
                if (student == null) {
                    return -2; // Mobile number not found
                }
            } catch (NumberFormatException e) {
                return -2; // Invalid mobile number
            }
        }

        if (!student.getPassword().equals(passwordStr)) {
            return -3; // Password mismatch
        }

        return student.getId(); // Successful login, return student ID
    }

    private StudentRegister getStudentByMobile(Long num) {
        return studentRepoRegi.findByMobile(num);
    }

    private StudentRegister getStudentByEmail(String email) {
        return studentRepoRegi.findByEmail(email);
    }

    private int checkType(String mobileEmail) {
        if (mobileEmail.contains("@")) {
            return 1; // Email
        }
        return 2; // Mobile number
    }
     
    
    
    @RequestMapping("getOneUserById/{id}")
    public StudentRegister loginStudent(@PathVariable int id) {
        StudentRegister st = studentRepoRegi.findById(id).orElse(null);  // Use orElse to handle null
        System.out.println(st);
        return st;
    }

    
}
