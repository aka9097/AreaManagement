import { Observable } from 'rxjs';
import { Location } from 'src/app/location';
import { Router, ActivatedRoute } from '@angular/router';
import { RestService } from './../../rest.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  // email!:string;
  users!: Observable<User[]>;
  location:Location[]=[];
  status:boolean=false;
  user:User=new User();


  constructor(private service:RestService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.service.getLocations().subscribe(
      data => {
        // console.log(data);
        this.location=data;
        console.log(this.location);
      },
      error => console.log(error)
    );
    this.users=this.service.getUser();
  }

  public getByEmail(email:string)
  {
    
     this.service.getUserByEmail(email).subscribe(
       data => {
         console.log(data);
         this.user=data;
         this.status=true;
       },
       error => console.log(error)
     );

    //  let resp=this.service.getAdminByEmail(this.email);

    //  resp.subscribe((data)=>this.admin=data);
    
    
  }
  public update()
  {
    this.service.updateUser(this.user).subscribe(
      data => {
        console.log(data),
        this.user=new User()
      },
      error => console.log(error)
    );
    
  }

  onSubmit() {
    this.update();    
  }

  back()
  {
    this.router.navigate(['admin/user']);
  }

}
