import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';

@Component({
  selector: 'app-delete-manager',
  templateUrl: './delete-manager.component.html',
  styleUrls: ['./delete-manager.component.css']
})
export class DeleteManagerComponent implements OnInit {

  users!: Observable<User[]>;

  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData()
  {
    this.users=this.service.getAreaManager();
  }

  delete(email:string)
  {
    this.service.deleteUser(email).subscribe(
      data => {
        console.log(data),
        this.reloadData()
      },
      error => console.log(error)
    );
  }

  back()
  {
    this.router.navigate(['admin/areaManager']);
  }

}
