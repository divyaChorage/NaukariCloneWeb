import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { StudentDashboardComponent } from '../../student-dashboard/student-dashboard.component';
@Component({
  selector: 'app-studet-personal-data',
  templateUrl: './studet-personal-data.component.html',
  styleUrls: ['./studet-personal-data.component.css']
})
export class StudetPersonalDataComponent {
  constructor(public app: AppComponent, private http: HttpClient, private studentDashboard: StudentDashboardComponent) {
    // Populate the component properties with the user data
    if (this.studentDashboard.user) {
      const user = this.studentDashboard.user;
      this.mobileNumber = user.mobileNumber || '';
      this.address = user.address || '';
      this.name = user.name || '';
      this.gender = user.gender || '';
      this.aadharCardNumber = user.aadharCardNumber || '';
      this.tenthPercentage = user.tenthPercentage || 0;
      this.tenthYear = user.tenthYear || 0;
      this.twelfthPercentage = user.twelfthPercentage || 0;
      this.twelfthYear = user.twelfthYear || 0;
      this.graduationYear = user.graduationYear || 0;
      this.graduationPercentage = user.graduationPercentage || 0;
      this.graduationStream = user.graduationStream || '';
      this.graduationCollegeName = user.graduationCollegeName || '';
      this.graduationUniversityName = user.graduationUniversityName || '';
      this.postGraduationYear = user.postGraduationYear || 0;
      this.postGraduationPercentage = user.postGraduationPercentage || 0;
      this.postGraduationStream = user.postGraduationStream || '';
      this.postGraduationCollegeName = user.postGraduationCollegeName || '';
      this.postGraduationUniversityName = user.postGraduationUniversityName || '';
      this.highestEducation = user.highestEducation || '';
      this.highestEducationYear = user.highestEducationYear || 0;
      this.highestEducationLastYearPercentage = user.highestEducationLastYearPercentage || 0;
      this.highestEducationAggregatePercentage = user.highestEducationAggregatePercentage || 0;
      this.yearGapInEducation = user.yearGapInEducation || 0;
      this.liveBacklog = user.liveBacklog || 0;
    }
  }

  // Personal Information
  mobileNumber: string = '';
  address: string = '';
  name: string = '';
  gender: string = '';
  aadharCardNumber: string = '';

  // Academic Information
  tenthPercentage: number = 0;
  tenthYear: number = 0;
  twelfthPercentage: number = 0;
  twelfthYear: number = 0;

  // Graduation Information
  graduationYear: number = 0;
  graduationPercentage: number = 0;
  graduationStream: string = '';
  graduationCollegeName: string = '';
  graduationUniversityName: string = '';

  // Post Graduation Information
  postGraduationYear: number = 0;
  postGraduationPercentage: number = 0;
  postGraduationStream: string = '';
  postGraduationCollegeName: string = '';
  postGraduationUniversityName: string = '';

  // Highest Education Information
  highestEducation: string = '';
  highestEducationYear: number = 0;
  highestEducationLastYearPercentage: number = 0;
  highestEducationAggregatePercentage: number = 0;

  // Additional Information
  yearGapInEducation: number = 0;  // 0 for No, 1 for Yes
  liveBacklog: number = 0;         // 0 for No, 1 for Yes

  updatToServer() {
    let obj = {
      mobileNumber: this.mobileNumber,
      address: this.address,
      name: this.name,
      gender: this.gender,
      aadharCardNumber: this.aadharCardNumber,
      tenthPercentage: this.tenthPercentage,
      tenthYear: this.tenthYear,
      twelfthPercentage: this.twelfthPercentage,
      twelfthYear: this.twelfthYear,
      graduationYear: this.graduationYear,
      graduationPercentage: this.graduationPercentage,
      graduationStream: this.graduationStream,
      graduationCollegeName: this.graduationCollegeName,
      graduationUniversityName: this.graduationUniversityName,
      postGraduationYear: this.postGraduationYear,
      postGraduationPercentage: this.postGraduationPercentage,
      postGraduationStream: this.postGraduationStream,
      postGraduationCollegeName: this.postGraduationCollegeName,
      postGraduationUniversityName: this.postGraduationUniversityName,
      highestEducation: this.highestEducation,
      highestEducationYear: this.highestEducationYear,
      highestEducationLastYearPercentage: this.highestEducationLastYearPercentage,
      highestEducationAggregatePercentage: this.highestEducationAggregatePercentage,
      yearGapInEducation: this.yearGapInEducation,
      liveBacklog: this.liveBacklog
    };

    console.log(obj)

    let url = this.app.url + 'personalInfo';
    this.http.post(url, obj).subscribe((data) => {
      if (data == 1) {
        window.alert('Data is updated on server');
      } else {
        window.alert('Something else');
      }
    }); 
  }
}
