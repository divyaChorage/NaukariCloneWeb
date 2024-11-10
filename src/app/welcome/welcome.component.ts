import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {

  constructor(private app: AppComponent) {}

  // Method to update whatToShow in AppComponent
  showComponent(num: number) {
    this.app.whatToShow = num; // Set the value to show student or recruiter login
  }
}
 