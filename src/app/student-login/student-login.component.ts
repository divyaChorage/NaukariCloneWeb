import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent {

  constructor(private app:AppComponent,private http:HttpClient){}

  name:string='';
  email:string='';
  mobile:number=0;

  showLoginform:number=0;

  register()
  {

    let url=this.app.url+'StudentRegister';
    let obj=
    {
      name:this.name,
      email:this.email,
        mobile:this.mobile
    }
    this.http.post(url,obj).subscribe((data)=>
    {
      if(data==-1)
        window.alert("please  enter valid email")
      else if(data==-2)
        window.alert("please  enter valid name")
      else if(data==-3)
        window.alert("please enter valid mobile number")
      else
      {
        window.alert("registration done")
        this.showLoginform=1;
      }
     
    })
    console.log(this.name+" "+this.mobile+" "+this.email)

  }




  username:string='';
  password:string='';

  alreadyLogged()
  {
    this.showLoginform=1;
  }




  loginStudent() {
    let obj = [this.username, this.password.toString()];
    let url = this.app.url + 'loginStudent';
    
    this.http.post(url, obj).subscribe((data) => {
        if (data == -1) {
            window.alert("Please enter a valid email");
        } else if (data == -2) {
            window.alert("Please enter a valid mobile number");
        } else if (data == -3) { // Corrected this line to check for password mismatch
            window.alert("Password does not match");
        } else {
            window.alert("Login successful");
            // You can also handle further actions here, such as navigating to a dashboard
        }  
    }, (error) => {
        // Optional: Handle HTTP errors here, such as network issues
        window.alert("An error occurred during the login process.");
        console.error(error);
    });
}

}
