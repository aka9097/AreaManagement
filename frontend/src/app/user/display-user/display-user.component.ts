import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';

@Component({
  selector: 'app-display-user',
  templateUrl: './display-user.component.html',
  styleUrls: ['./display-user.component.css']
})
export class DisplayUserComponent implements OnInit {

  users!: Observable<User[]>;
  sortUsers!:any;
  locationName!:string;
  status:boolean=false;
  status1:boolean=false;
  constructor( private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.users=this.service.getUser();
    this.status=true;

  }

  sortByLocation()
  {
     this.service.userSortByLocation(this.locationName).subscribe(
       data=>{
         this.sortUsers=data;
         console.log(data);
       },
       error=>console.error(error)
     );
    // console.log(this.sortUsers);
    this.status1=true;
    this.status=false;
  }

  back()
  {
    this.router.navigate(['admin/user']);
  }

}
