import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  employeeToAdd: Employee | undefined
  errorMessage: String = ''
  successMessage: String = ''

  constructor(private service: EmployeeService) { }

  ngOnInit(): void { }

  addEmployee() {
    this.service.addService(this.employeeToAdd!).subscribe(response => {
      this.successMessage = response;
      let id = this.successMessage.substring(0, this.successMessage.indexOf(':') + 1).trim();
      this.employeeToAdd!.employeeId = parseInt(id)
    }, error => this.errorMessage = error);
  }

}
