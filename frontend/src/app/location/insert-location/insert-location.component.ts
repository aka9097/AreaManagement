import { Route, Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/location';

@Component({
  selector: 'app-insert-location',
  templateUrl: './insert-location.component.html',
  styleUrls: ['./insert-location.component.css']
})
export class InsertLocationComponent implements OnInit {

  location:Location=new Location();
  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
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
