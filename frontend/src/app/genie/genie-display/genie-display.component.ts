import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Genie } from 'src/app/genie';
import { RestService } from 'src/app/rest.service';

@Component({
  selector: 'app-genie-display',
  templateUrl: './genie-display.component.html',
  styleUrls: ['./genie-display.component.css']
})
export class GenieDisplayComponent implements OnInit {

  genies!: Observable<Genie[]>;
  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.genies=this.service.getAllGenie();
    console.log(this.genies);
  }

  back()
  {
    this.router.navigate(['admin/genie']);
  }

}
