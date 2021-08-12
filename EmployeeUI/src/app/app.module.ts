import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { DeleteEmployeeComponent } from './delete-employee/delete-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { FeatherModule } from 'angular-feather';
import { Plus, Users, Settings, X } from 'angular-feather/icons';

const icons = {
  Plus,
  Users, 
  Settings, 
  X
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddEmployeeComponent,
    ViewEmployeeComponent,
    DeleteEmployeeComponent,
    UpdateEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FeatherModule.pick(icons)
  ],
  exports: [
    FeatherModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
