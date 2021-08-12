import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { DeleteEmployeeComponent } from './delete-employee/delete-employee.component';
import { HomeComponent } from './home/home.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';

const routes: Routes = [
  { path:'dashboard', component: HomeComponent, children:[
    { path:'addEmployee', component: AddEmployeeComponent },
    { path:'viewEmployees', component: ViewEmployeeComponent },
    { path:'deleteEmployee', component: DeleteEmployeeComponent },
    { path:'updateEmployeeDetails', component: UpdateEmployeeComponent }
  ] },
  { path: '', redirectTo: '/dashboard', pathMatch:'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    // RouterModule.forChild(routesC)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
