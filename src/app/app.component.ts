import { Component } from '@angular/core';

import {HttpClient} from '@angular/common/http'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Naukari';

  constructor(private http:HttpClient){
    
  }
 
  whatToShow:number=0;
   url:string='http://localhost:8080/';
  


}
