import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Genie } from 'src/app/genie';
import { RestService } from 'src/app/rest.service';

@Component({
  selector: 'app-genie-delete',
  templateUrl: './genie-delete.component.html',
  styleUrls: ['./genie-delete.component.css']
})
export class GenieDeleteComponent implements OnInit {

  genies!: Observable<Genie[]>;
  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData()
  {
    this.genies=this.service.getAllGenie();
  }

  deleteGenie(id:number)
  {
    this.service.deleteGenie(id).subscribe(
      data => {
        console.log(data),
        this.reloadData()
      },
      error => console.log(error)
    );
  }

  back()
  {
    this.router.navigate(['admin/genie']);
  }

}
