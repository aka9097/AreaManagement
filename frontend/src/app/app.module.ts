import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { IndexComponent } from './index/index.component';
import { RestService } from './rest.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UpdateAdminProfileComponent } from './admin/update-admin-profile/update-admin-profile.component';
import { InsertUserComponent } from './user/insert-user/insert-user.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { DeleteUserComponent } from './user/delete-user/delete-user.component';
import { DisplayUserComponent } from './user/display-user/display-user.component';
import { UserComponent } from './user/user/user.component';
import { InsertManagerComponent } from './area-manager/insert-manager/insert-manager.component';
import { DisplayManagerComponent } from './area-manager/display-manager/display-manager.component';
import { DeleteManagerComponent } from './area-manager/delete-manager/delete-manager.component';
import { UpdateManagerComponent } from './area-manager/update-manager/update-manager.component';
import { AreaManagerComponent } from './area-manager/area-manager/area-manager.component';
import { GenieComponent } from './genie/genie/genie.component';
import { GenieInsertComponent } from './genie/genie-insert/genie-insert.component';
import { GenieDisplayComponent } from './genie/genie-display/genie-display.component';
import { GenieDeleteComponent } from './genie/genie-delete/genie-delete.component';
import { GenieUpdateComponent } from './genie/genie-update/genie-update.component';
import { InsertLocationComponent } from './location/insert-location/insert-location.component';
import { DeleteLocationComponent } from './location/delete-location/delete-location.component';
import { DisplayLocationComponent } from './location/display-location/display-location.component';
import { UpdateLocationComponent } from './location/update-location/update-location.component';
import { LocationDashboardComponent } from './location/location-dashboard/location-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserdashboardComponent,
    IndexComponent,
    AdminLoginComponent,
    AdminDashboardComponent,
    UpdateAdminProfileComponent,
    InsertUserComponent,
    UpdateUserComponent,
    DeleteUserComponent,
    DisplayUserComponent,
    UserComponent,
    InsertManagerComponent,
    DisplayManagerComponent,
    DeleteManagerComponent,
    UpdateManagerComponent,
    AreaManagerComponent,
    GenieComponent,
    GenieInsertComponent,
    GenieDisplayComponent,
    GenieDeleteComponent,
    GenieUpdateComponent,
    InsertLocationComponent,
    DeleteLocationComponent,
    DisplayLocationComponent,
    UpdateLocationComponent,
    LocationDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [RestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
