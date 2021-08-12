import { Address } from './../../address';
import { User } from 'src/app/User';

import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from 'src/app/location';

@Component({
  selector: 'app-insert-manager',
  templateUrl: './insert-manager.component.html',
  styleUrls: ['./insert-manager.component.css']
})
export class InsertManagerComponent implements OnInit {

  user: User=new User();
  submitted=false
  location:Location=new Location();
  locationName!:string;
  location2:Location[]=[];
  address:Address=new Address();


  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
   
    this.service.getLocations().subscribe(
      data => {
        // console.log(data);
        this.location2=data;
        console.log(this.location2);
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

  // public getByLocationName()
  // {
    
  //    this.service.getByLocationName(this.locationName).subscribe(
  //      data => {
  //        console.log(data);
  //        this.location=data;
  //      },
  //      error => console.log(error)
  //    );
//}

back()
{
  this.router.navigate(['admin/areaManager']);
}
}
