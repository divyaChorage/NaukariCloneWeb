import { Component } from '@angular/core';

@Component({
  selector: 'app-recruiterdashboard',
  templateUrl: './recruiterdashboard.component.html',
  styleUrls: ['./recruiterdashboard.component.css']
})
export class RecruiterdashboardComponent {

  showrecruterDash:number=0;
  navigateToComanyData:number=0;




  toNavigateComapanyData(num:number)
  {
    console.log(num);
    
this.navigateToComanyData=num
this.showrecruterDash=1;
  }




  
}
 