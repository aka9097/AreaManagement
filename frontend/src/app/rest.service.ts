import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { Admin } from './admin';
import { User } from './User';
import { Location } from './location';
import { Genie } from './genie';

@Injectable({
  providedIn: 'root'
})
export class RestService {
  admin: Admin[] = [];
  areaManager:User[]=[];
  user:User=new User();
  genie:Genie[]=[];


  constructor(private http:HttpClient) { }

  
public login(username:string,password:string){
  const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
  return this.http.get("http://localhost:8080/login",{headers,responseType: 'text' as 'json'})
}


public adminLogin(username:string,password:string){
  console.log(username + password);
  const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
  return this.http.get("http://localhost:8080/adminLogin",{headers,responseType: 'text' as 'json'})
}

// public getAdmin(email:String): Observable<any> {
//   return this.http.get(`"http://localhost:8080/getAdmin"/${email}`);
// }

// public updateAdmin( value: any): Observable<Object> {
//   return this.http.put(`${"http://localhost:8080/updateAdminProfile"}`, value);
// }

public getAdminByEmail(email:string,password:string):Observable<any>
{
    return this.http.get("http://localhost:8080/admin/"+email+"/"+password);
}

public updateAdmin(admin: any)
{
  return this.http.put("http://localhost:8080/admin/updateprofile",admin);
}

public insertAreaManager(areaManager: Object): Observable<Object> {
  return this.http.post("http://localhost:8080/user", areaManager);
}

public updateAreaManager(user: any): Observable<Object> {
  return this.http.put("http://localhost:8080/updateUserProfile",user);
}

public deleteAreaManager(email: string): Observable<any> {
  return this.http.delete("http://localhost:8080/deleteUser/"+email, { responseType: 'text' });
}

public getAreaManager(): Observable<any> {
  return this.http.get("http://localhost:8080/areamanagers");
}

public getAreaManagerByEmail(email:string):Observable<any>
{
    return this.http.get("http://localhost:8080/user/"+email);
}

public insertUser(user: Object): Observable<Object> {
  return this.http.post("http://localhost:8080/user", user);
}

public updateUser( value: any): Observable<Object> {
  return this.http.put("http://localhost:8080/updateUserProfile",value);
}

public deleteUser(email: string): Observable<any> {
  return this.http.delete("http://localhost:8080/deleteUser/"+email, { responseType: 'text' });
}

public getUser(): Observable<any> {
  return this.http.get("http://localhost:8080/users");
}

public getUserByEmail(email:string):Observable<any>
{
    return this.http.get("http://localhost:8080/user/"+email);
}

public getByLocationName(locationName:string):Observable<Location>
{
  return this.http.get<Location>("http://localhost:8080/location/"+locationName);
}

public getLocations():Observable<Location[]>
{
  return this.http.get<Location[]>("http://localhost:8080/location")
}

public addLocation(location:Object):Observable<any>
{
  return this.http.post("http://localhost:8080/location",location);
}

public updateLocation(location:Object):Observable<any>
{
  return this.http.put("http://localhost:8080/location",location);
}

public deleteLocationByName(locationName:string):Observable<any>
{
  return this.http.delete("http://localhost:8080/location/"+locationName, { responseType: 'text' });
}

public userSortByLocation(locationName:string):Observable<any>
{
  return this.http.get("http://localhost:8080/users/"+locationName);
}

public areaManagersSortByLocation(locationName:string):Observable<any>
{
  return this.http.get("http://localhost:8080/areamanagers/"+locationName);
}

public updateGenie(genie:Genie,id:number): Observable<Object> {
  return this.http.put("http://localhost:8080/genie/"+id,genie);
}

public deleteGenie(id:number): Observable<any> {
  return this.http.delete("http://localhost:8080/deleteUser/"+id, { responseType: 'text' });
}

public getAllGenie(): Observable<Genie[]> {
  return this.http.get<Genie[]>("http://localhost:8080/genie");
}

public getGenieById(id:number):Observable<any>
{
    return this.http.get("http://localhost:8080/getGenie/"+id);
}



}



