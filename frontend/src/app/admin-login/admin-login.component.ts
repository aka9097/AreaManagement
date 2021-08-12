import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  
  username!: string;
  password !: string;
  message: any

  constructor(private service: RestService,private router:Router) { }

  ngOnInit(): void {
  }

  
  doLogin() {
    let resp = this.service.adminLogin(this.username, this.password);
    resp.subscribe(data => {
      this.message = data;
      console.log(this.message)
     this.router.navigate(["/admindashboard"])
    });
  }

}
