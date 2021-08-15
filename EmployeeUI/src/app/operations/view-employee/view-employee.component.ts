import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {

  employees: Employee[] = []
  errorMessage: String = ''
  successMessage: String = ''
  searchText!: string

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
    this.service.viewService().subscribe(
      employee => this.employees = employee,
      error => this.errorMessage = error)
  }

  search() {
    this.successMessage = ''
    this.errorMessage = ''
    this.employees = []
    // const text = document.getElementById('search')!.innerText
    if(this.searchText.trim()==='')
      this.ngOnInit()
    else {
      let employeeId = parseInt(this.searchText)
      if (!isNaN(employeeId))
        this.service.getService(employeeId).subscribe(
          employee => this.employees = [employee],
          error => this.errorMessage = error.errorMessage)
      else 
          this.errorMessage = 'Employee Id is a number of minimum length 7. Please enter a valid employee id.'
    }
  }

}
