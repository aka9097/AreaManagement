import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string;
  password !: string;
  message: any

  constructor(private service: RestService,private router:Router) { }

  ngOnInit(): void {
  }

  
  doLogin() {
    let resp = this.service.login(this.username, this.password);
    resp.subscribe(data => {
      this.message = data;
      console.log(this.message)
     this.router.navigate(["/userdashboard"])
    });
  }

  adminLogin() {
    let resp = this.service.login(this.username, this.password);
    resp.subscribe(data => {
      this.message = data;
      console.log(this.message)
     this.router.navigate(["/adminDashboard"])
    });
  }

}
