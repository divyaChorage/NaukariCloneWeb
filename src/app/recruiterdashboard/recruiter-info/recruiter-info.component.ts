import { Component } from '@angular/core';

@Component({
  selector: 'app-recruiter-info',
  templateUrl: './recruiter-info.component.html',
  styleUrls: ['./recruiter-info.component.css']
})
export class RecruiterInfoComponent {


  // Recruiter Information
  fullName: string = ''; // Full Name of the recruiter
  email: string = ''; // Recruiter's email address
  mobileNumber: string = ''; // Recruiter's mobile number
  designation: string = ''; // Recruiter's job title

  industryType: string = ''; // Industry type (e.g., IT, Finance)

  
  constructor() {}

  registerRecruiter() {
    // Logic for registering the recruiter would go here
    console.log('Recruiter Registration Data:', {
      fullName: this.fullName,
      email: this.email,
      mobileNumber: this.mobileNumber,
      designation: this.designation,

      industryType: this.industryType,

    });
  }
}
