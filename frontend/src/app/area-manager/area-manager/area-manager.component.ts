import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-area-manager',
  templateUrl: './area-manager.component.html',
  styleUrls: ['./area-manager.component.css']
})
export class AreaManagerComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  back()
  {
    this.router.navigate(['/admindashboard']);
  }

}
