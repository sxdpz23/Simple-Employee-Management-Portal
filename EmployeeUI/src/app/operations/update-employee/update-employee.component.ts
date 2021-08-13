import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee: Employee | undefined;
  errorMessage: String = ''
  successMessage: String = ''

  constructor(private service: EmployeeService) { }

  ngOnInit(): void { }

  search() {
    this.successMessage = ''
    this.errorMessage = ''
    this.employee = undefined
    if(document.getElementById('search')!.style.display=='none') 
    this.preSearchAction()
    else {
      const text = document.getElementById('search')!.innerText
      let employeeId = parseInt(text)
      if (!isNaN(employeeId))
        this.service.getService(employeeId).subscribe(
          employee => this.employee = employee,
          error => this.errorMessage = error.errorMessage)
      else
        this.errorMessage = 'Employee Id is a number of minimum length 7. Please enter a valid employee id.'
      setTimeout(() => this.postSearchAction(), 500)
    }
  }

  updateEmployee() {
    this.successMessage = ''
    this.errorMessage = ''
    this.service.updateService(this.employee!).subscribe(
      response => this.successMessage = response,
      error => this.errorMessage = error)
  }

  preSearchAction() {
    var update = document.getElementById('update')
    var searchBox = document.getElementById('search')
    var button = document.getElementById('button')
    
    update!.style.opacity = '0'
    searchBox!.style.display = 'block'
    button!.style.backgroundImage = 'none'
    button!.style.backgroundColor = 'transparent'
    button!.style.color = '#000'
    setTimeout(() => {
      button!.style.right = '9vw'
      button!.style.top = '9.5vh'
      searchBox!.style.opacity = '1'
      update!.style.display = 'none'
    }, 500)
  }

  postSearchAction() {
    var update = document.getElementById('update')
    var searchBox = document.getElementById('search')
    var button = document.getElementById('button')

    if (this.employee != undefined) {
      update!.style.display = 'block'
      searchBox!.style.opacity = '0'
      button!.style.right = '24vw'
      button!.style.top = '10.5vh'
      button!.style.backgroundColor = '#fff'
      setTimeout(() => {
        update!.style.opacity = '1'
        searchBox!.style.display = 'none'
        button!.style.backgroundImage = 'linear-gradient(rgba(255, 100, 0, 0.5), rgba(255, 0, 0, 0.7), rgba(255, 0, 0, 0.9))'
        button!.style.color = '#fff'
      }, 500)
    }
  }

}
