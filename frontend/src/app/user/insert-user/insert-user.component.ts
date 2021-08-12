import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';
import { Location } from 'src/app/location';

@Component({
  selector: 'app-insert-user',
  templateUrl: './insert-user.component.html',
  styleUrls: ['./insert-user.component.css']
})
export class InsertUserComponent implements OnInit {
  location:Location[]=[];
  locationName!:string;
  user: User =new User();
  submitted=false;
  location1!:any;

  
  constructor(private service:RestService,private router:Router) { }

  
  ngOnInit(): void {
   
    this.service.getLocations().subscribe(
      data => {
        // console.log(data);
        this.location=data;
        console.log(this.location);
      },
      error => console.log(error)
    );
    // this.location1=this.service.getLocations();
  }

  save()
  {
    this.service.insertAreaManager(this.user).subscribe(
      data => {
        console.log(data);
        this.user=new User();
      },
      error => console.log(error)
    );
  }

  
  onSubmit()
  {
    this.submitted=true;
    this.save();
  }

  back()
  {
    this.router.navigate(['admin/user']);
  }

}
