import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/location';

@Component({
  selector: 'app-delete-location',
  templateUrl: './delete-location.component.html',
  styleUrls: ['./delete-location.component.css']
})
export class DeleteLocationComponent implements OnInit {

  location!:Observable<Location[]>;
  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData()
  {
    this.location=this.service.getLocations();
  }

  delete(locationName:string)
  {
    this.service.deleteLocationByName(locationName).subscribe(
      data => {
        console.log(data),
        this.reloadData()
      },
      error => console.log(error)
    );
  }

  back()
  {
    this.router.navigate(['admin/location']);
  }

}
