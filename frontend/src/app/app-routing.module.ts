import { LocationDashboardComponent } from './location/location-dashboard/location-dashboard.component';
import { DeleteLocationComponent } from './location/delete-location/delete-location.component';
import { UpdateLocationComponent } from './location/update-location/update-location.component';
import { DisplayLocationComponent } from './location/display-location/display-location.component';
import { InsertLocationComponent } from './location/insert-location/insert-location.component';
import { UpdateAdminProfileComponent } from './admin/update-admin-profile/update-admin-profile.component';
import { GenieUpdateComponent } from './genie/genie-update/genie-update.component';
import { GenieInsertComponent } from './genie/genie-insert/genie-insert.component';
import { GenieComponent } from './genie/genie/genie.component';
import { DeleteManagerComponent } from './area-manager/delete-manager/delete-manager.component';
import { UpdateManagerComponent } from './area-manager/update-manager/update-manager.component';
import { DisplayManagerComponent } from './area-manager/display-manager/display-manager.component';
import { AreaManagerComponent } from './area-manager/area-manager/area-manager.component';
import { UserComponent } from './user/user/user.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { DeleteUserComponent } from './user/delete-user/delete-user.component';
import { DisplayUserComponent } from './user/display-user/display-user.component';
import { InsertUserComponent } from './user/insert-user/insert-user.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './login/login.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { InsertManagerComponent } from './area-manager/insert-manager/insert-manager.component';
import { GenieDisplayComponent } from './genie/genie-display/genie-display.component';
import { GenieDeleteComponent } from './genie/genie-delete/genie-delete.component';

const routes: Routes = [

  {
    path:"",
    redirectTo:"index",
    pathMatch:"full"
  },

  {
    path:"index",
    component:IndexComponent
  },
  {
    path:"login",
    component:LoginComponent
  },

  {
    path:"userdashboard",
    component:UserdashboardComponent
  },

  {
    path:"adminLogin",
    component:AdminLoginComponent
  },

  {
    path:"admin/update",
    component:UpdateAdminProfileComponent
  },

  {
    path:"admindashboard",
    component:AdminDashboardComponent
  },

  {
    path:"admin/user",
    component:UserComponent
  },

  {
    path:"admin/user/insert",
    component:InsertUserComponent
  },

  {
    path:"admin/user/display",
    component:DisplayUserComponent
  },

  {
    path:"admin/user/delete",
    component:DeleteUserComponent
  },

  {
    path:"admin/user/update",
    component:UpdateUserComponent
  },

  {
    path:"admin/areaManager",
    component:AreaManagerComponent
  },

  {
    path:"admin/areaManager/insert",
    component:InsertManagerComponent
  },

  {
    path:"admin/areaManager/display",
    component:DisplayManagerComponent
  },

  {
    path:"admin/areaManager/update",
    component:UpdateManagerComponent
  },

  {
    path:"admin/areaManager/delete",
    component:DeleteManagerComponent
  },

  {
    path:"admin/genie",
    component:GenieComponent
  },

  {
    path:"admin/genie/insert",
    component:GenieInsertComponent
  },

  {
    path:"admin/genie/display",
    component:GenieDisplayComponent
  },

  {
    path:"admin/genie/update",
    component:GenieUpdateComponent
  },

  {
    path:"admin/genie/delete",
    component:GenieDeleteComponent
  },

  {
    path:"admin/location",
    component:LocationDashboardComponent
  },
  
  {
    path:"admin/location/insert",
    component:InsertLocationComponent
  },
  {
    path:"admin/location/display",
    component:DisplayLocationComponent
  },
  {
    path:"admin/location/update",
    component:UpdateLocationComponent
  },
  {
    path:"admin/location/delete",
    component:DeleteLocationComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
