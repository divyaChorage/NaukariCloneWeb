import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent {
  user: any;

  constructor(public app: AppComponent, private http: HttpClient) {
    if (this.app.userId) {
      let url = this.app.url + 'getOneUserById/' + this.app.userId;
      this.http.get(url).subscribe((data) => {
        console.log(data);
        this.user = data;
      }, (error) => {
        console.error("Error fetching user data:", error);
      });
    } else {
      console.error("No userId found. User not logged in.");
    }
  }


  showstudentComponents:number=0;
  studentComponents(num:number)
  {
this.showstudentComponents=num;
  }
}
