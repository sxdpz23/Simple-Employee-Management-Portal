import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {

  employee!: Employee | undefined
  errorMessage: String = ''
  successMessage: String = ''
  searchText!: string

  constructor(private service: EmployeeService) { }

  ngOnInit(): void { }

  search() {
    this.successMessage = ''
    this.errorMessage = ''
    this.employee = undefined
    let employeeId = parseInt(this.searchText)
    if (!isNaN(employeeId))
      this.service.getService(employeeId).subscribe(
        employee => this.employee = employee,
        error => this.errorMessage = error.errorMessage)
    else 
        this.errorMessage = 'Employee Id is a number of minimum length 7. Please enter a valid employee id.'
  }

  removeEmployee() {
    this.successMessage = ''
    this.errorMessage = ''
    this.service.deleteService(this.employee!.employeeId!).subscribe(
      response => this.successMessage = response,
      error => this.errorMessage = error)
  }

}
