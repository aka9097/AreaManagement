import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { RestService } from './../../rest.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {

  users!: Observable<User[]>;

  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData()
  {
    this.users=this.service.getUser();
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
    this.router.navigate(['admin/user']);
  }

}
