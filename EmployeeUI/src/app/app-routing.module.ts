import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './operations/add-employee/add-employee.component';
import { DeleteEmployeeComponent } from './operations/delete-employee/delete-employee.component';
import { HomeComponent } from './home/home.component';
import { UpdateEmployeeComponent } from './operations/update-employee/update-employee.component';
import { ViewEmployeeComponent } from './operations/view-employee/view-employee.component';
import { OperationsComponent } from './operations/operations.component';

const routes: Routes = [
  { path:'dashboard', children:[
    { path:'', component: HomeComponent },
    { path:'**', component: OperationsComponent },
    { path:'viewEmployees', component: ViewEmployeeComponent },
    { path:'deleteEmployee', component: DeleteEmployeeComponent },
    { path:'updateEmployeeDetails', component: UpdateEmployeeComponent }
  ] },
  { path: '', redirectTo: '/dashboard', pathMatch:'full' },
  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      onSameUrlNavigation: 'reload'
    }),
    // RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
