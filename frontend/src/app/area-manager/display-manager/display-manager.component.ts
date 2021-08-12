import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';

@Component({
  selector: 'app-display-manager',
  templateUrl: './display-manager.component.html',
  styleUrls: ['./display-manager.component.css']
})
export class DisplayManagerComponent implements OnInit {

  users!: Observable<User[]>;
  sortUsers!:any;
  locationName!:string;
  status:boolean=false;
  status1:boolean=false;

  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData()
  {
    this.users=this.service.getAreaManager();
    this.status=true;
  }

  sortByLocation()
  {
     this.service.areaManagersSortByLocation(this.locationName).subscribe(
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
    this.router.navigate(['admin/areaManager']);
  }

}
