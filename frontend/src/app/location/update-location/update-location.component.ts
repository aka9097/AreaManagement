import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/location';

@Component({
  selector: 'app-update-location',
  templateUrl: './update-location.component.html',
  styleUrls: ['./update-location.component.css']
})
export class UpdateLocationComponent implements OnInit {
  locationName!:string;
  location:Location=new Location();
  status:boolean=false;

  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
  }

  public locationByName()
  {
    this.service.getByLocationName(this.locationName).subscribe(
      data => {
        console.log(data);
        this.location=data;
        this.status=true;
      },
      error => console.log(error)
    );
  }

  public save()
  {
    this.service.addLocation(this.location).subscribe(
      data => {
        console.log(data);
        this.location=new Location();
      },
      error => console.log(error)
    );
  }

  back()
  {
    this.router.navigate(['admin/location']);
  }

}
