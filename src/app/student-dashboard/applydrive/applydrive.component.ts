import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-applydrive',
  templateUrl: './applydrive.component.html',
  styleUrls: ['./applydrive.component.css']
})
export class ApplydriveComponent {


  companies:any
  constructor(public app: AppComponent, private http: HttpClient) {
    if (this.app.userId) {
      let url = this.app.url + 'getAllComapnies';
      this.http.get(url).subscribe((data) => {
        console.log(data);
        this.companies = data;
      }, (error) => {
        console.error("Error fetching comapnies:", error);
      });
    } else {
      console.error("No comapnies.");
    }
  }


  selectedFiles: { [key: string]: File } = {};

  onFileSelected(event: any, companyId: string) {
    const file = event.target.files[0];
    if (file) {
      this.selectedFiles[companyId] = file;
    }
  }

  apply(companyId: string) {
    const file = this.selectedFiles[companyId];

    const selectedCompany = this.companies.find((company: any) => company.id === companyId);

  console.log("selectedCompany--",selectedCompany);
  

    if (file) {
      const formData = new FormData();
      formData.append('userId', this.app.userId);
      formData.append('companyId', companyId);
      formData.append('companyName', selectedCompany.companyName); // Add company name to the form data

      formData.append('recruiterId', selectedCompany.recruiterId); // Add recruiterId to the form data

      formData.append('resume', file);

      console.log(file);
      
      const url = this.app.url + 'applyForCompany'+'/'+this.app.userId;
      this.http.post(url, formData).subscribe(
        (response) => {

          console.log('Application submitted successfully:', response);
          alert('Application submitted successfully!');
          this.companies = this.companies.filter((company: any) => company.id !== companyId);

        },
        (error) => {
          console.error('Error submitting application:', error);
          alert('Failed to submit application.');
        }
      );
    } else {
      alert('Please upload your resume before applying.');
    }
  }

  


  loadAppliedCompanies:any
showAppliedCompany:number=0;

  viewAppliedCompanies()
  {
    this.showAppliedCompany=1;
    const url = this.app.url + 'viewAppliedCompanies'+'/'+this.app.userId;
    this.http.get(url).subscribe(
      (response) => {
       
       console.log("--",response);
       this.loadAppliedCompanies=response;
      },
      (error) => {
        console.error('getting  apllied companiesz', error);
        alert('Your  not  applied any companies');
      }
    );
  }


  
 

}
 