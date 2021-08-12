import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/location';

@Component({
  selector: 'app-display-location',
  templateUrl: './display-location.component.html',
  styleUrls: ['./display-location.component.css']
})
export class DisplayLocationComponent implements OnInit {

  location!: Observable<Location[]>;

  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData()
  {
    this.location=this.service.getLocations();
  }

  back()
  {
    this.router.navigate(['admin/location']);
  }

}
