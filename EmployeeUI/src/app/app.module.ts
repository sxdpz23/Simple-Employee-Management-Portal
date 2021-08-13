import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { FeatherModule } from 'angular-feather';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddEmployeeComponent } from './operations/add-employee/add-employee.component';
import { ViewEmployeeComponent } from './operations/view-employee/view-employee.component';
import { DeleteEmployeeComponent } from './operations/delete-employee/delete-employee.component';
import { UpdateEmployeeComponent } from './operations/update-employee/update-employee.component';
import { Plus, Users, Settings, X, ChevronsLeft, Search, Check, UploadCloud } from 'angular-feather/icons';
import { OperationsComponent } from './operations/operations.component';
import { EmployeeService } from './operations/employee.service';
import { DatePipe } from './shared/pipes/date.pipe';

const icons = {
  Plus,
  Users, 
  Settings, 
  X, 
  ChevronsLeft,
  Search, 
  Check,
  UploadCloud
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddEmployeeComponent,
    ViewEmployeeComponent,
    DeleteEmployeeComponent,
    UpdateEmployeeComponent,
    OperationsComponent,
    DatePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FeatherModule.pick(icons)
  ],
  exports: [
    FeatherModule
  ],
  providers: [
    EmployeeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
