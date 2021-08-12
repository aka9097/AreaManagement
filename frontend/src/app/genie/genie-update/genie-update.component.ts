
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from 'src/app/User';
import { Component, OnInit } from '@angular/core';
import { Genie } from 'src/app/genie';
import { RestService } from 'src/app/rest.service';



@Component({
  selector: 'app-genie-update',
  templateUrl: './genie-update.component.html',
  styleUrls: ['./genie-update.component.css']
})
export class GenieUpdateComponent implements OnInit {

  genies!: Observable<Genie[]>;
  status:boolean=false;
  genie:Genie=new Genie();
  user:User=new User();


  constructor(private service:RestService,private router:Router) { }

  ngOnInit(): void {
    this.genies=this.service.getAllGenie();
  }

  public getByGenie(id:number)
  {
    
     this.service.getGenieById(id).subscribe(
       data => {
         console.log(data);
         this.genie=data;
         this.status=true;
       },
       error => console.log(error)
     );

    //  let resp=this.service.getAdminByEmail(this.email);

    //  resp.subscribe((data)=>this.admin=data);
    
    
  }
  public update(id:number)
  {
    this.service.updateGenie(this.genie,id).subscribe(
      data => {
        console.log(data),
        this.genie=new Genie()
      },
      error => console.log(error)
    );
    this.status=false;
    
  }

  // onSubmit() {
  //   this.update();    
  // }


  back()
  {
    this.router.navigate(['admin/genie']);
  }
  
}
