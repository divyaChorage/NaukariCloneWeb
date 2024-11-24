import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-companiesdata',
  templateUrl: './companiesdata.component.html',
  styleUrls: ['./companiesdata.component.css']
})
export class CompaniesdataComponent {

constructor(public app:AppComponent,public  http :HttpClient){
  
}

companyName: string=' ';
position: string=' ';
noOfVacancies: number=0;
  skillsRequired: string='';
  experience: string=' '; 
  bond: number=0;
  salary: string=' ';
  passoutYear: number=0;
  applicationDeadline: Date | undefined;


    addCompanyData() {
      let obj = {
        companyName: this.companyName,
        position: this.position,
        noOfVacancies: this.noOfVacancies,
        skillsRequired: this.skillsRequired.split(',').map(skill => skill.trim()), // Split comma-separated input into an array
        experience: this.experience,
        bond: this.bond, // 1 for yes, 0 for no
        salary: this.salary,
        passoutYear: this.passoutYear,
        applicationDeadline: this.applicationDeadline,
      };


      console.log("recruiterId",this.app.userId);
      
      let url=this.app.url+'addCompany/'+this.app.userId
      this.http.post(url,obj).subscribe((data)=>
        {
         window.alert("company added")
         
        })
    
      console.log(obj);
    }
    
    
showAllComapny:number=0;

    viewAddedComapnies()
    {
this.showAllComapny=1;
    }
  
}
 