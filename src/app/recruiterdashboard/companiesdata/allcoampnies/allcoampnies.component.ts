import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import * as XLSX from 'xlsx';
@Component({
  selector: 'app-allcoampnies',
  templateUrl: './allcoampnies.component.html',
  styleUrls: ['./allcoampnies.component.css']
})
export class AllcoampniesComponent {

comapnies:any
  constructor(public app:AppComponent,public  http :HttpClient){
    let url=this.app.url+'getAllComapnies/'+this.app.userId
    this.http.get(url).subscribe((data)=>
      {
   console.log(data);
   this.comapnies=data;
       
      })
  }


showStudentsForComapnye:number=0;
  students:any

  viewApplicatnsForThisCompany(cId:number)
  {
    this.showStudentsForComapnye=1;
    console.log(cId);

    let url=this.app.url+'getAllStudentsAppliedForCompany/'+cId
    this.http.get(url).subscribe((data)=>
      {
   console.log(data);
   this.students=data;
       
      })
    
  }




  downloadResume(resumePath: string): void {
    const fileName = resumePath.split('\\').pop(); // Extract file name from path
    const url = this.app.url+"downloadResume"+'/'+fileName;
  
    this.http.get(url, { responseType: 'blob' }).subscribe((response) => {
      const blob = new Blob([response], { type: 'application/pdf' });
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = fileName || 'resume.pdf';
      link.click();
    }, error => {
      console.error('Error downloading file:', error);
    });
  }

  

  exportToExcel(): void {
    const worksheet = XLSX.utils.json_to_sheet(this.students);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, 'Applicants');
    XLSX.writeFile(workbook, 'Applicants.xlsx');
  }
}
  