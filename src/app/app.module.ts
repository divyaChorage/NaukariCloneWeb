import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RecruiterLoginComponent } from './recruiter-login/recruiter-login.component';
import { StudentLoginComponent } from './student-login/student-login.component';



@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    RecruiterLoginComponent,
    StudentLoginComponent,
 
  
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
