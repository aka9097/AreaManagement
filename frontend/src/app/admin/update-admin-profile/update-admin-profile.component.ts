import { Admin } from 'src/app/admin';
import { Router, ActivatedRoute } from '@angular/router';
import { RestService } from './../../rest.service';
import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-update-admin-profile',
  templateUrl: './update-admin-profile.component.html',
  styleUrls: ['./update-admin-profile.component.css']
})
export class UpdateAdminProfileComponent implements OnInit {

  email!:string;
  admin: Admin=new Admin();
  password!:string;
  status:boolean=false;
  
  constructor(private service:RestService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
  }

  public getByEmail()
  {
    
     this.service.getAdminByEmail(this.email,this.password).subscribe(
       data => {
         console.log(data);
         this.admin=data;
         this.status=true;
       },
       error => console.log(error)
     );

    //  let resp=this.service.getAdminByEmail(this.email);

    //  resp.subscribe((data)=>this.admin=data);
    
    
  }
  public update()
  {
    this.service.updateAdmin(this.admin).subscribe(
      data => {
        console.log(data),
        this.admin=new Admin()
      },
      error => console.log(error)
    );
    
  }

  onSubmit() {
    this.update();    
  }

  back()
  {
    this.router.navigate(['/admindashboard']);
  }
}
