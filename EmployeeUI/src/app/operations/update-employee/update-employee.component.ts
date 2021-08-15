import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeTraining } from 'src/app/shared/models/employeeTraining';
import { ETStatus } from 'src/app/shared/models/etStatus';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee: Employee  = new Employee();
  errorMessage: String = ''
  successMessage: String = ''
  searchText!: string 
  titles: string[] = [
    'name', 'course details', 'location', 'score', 'hours spent', 'status', 'phone', 'email'
  ]
  nameT: any = false
  locationT: any = false
  phone1T: any = false
  phone2T: any = false
  emailT: any = false
  courseCodeT: any = false
  scoreT: any = false
  hoursSpentT: any = false
  dateCompletedT: any = false

  constructor(private service: EmployeeService) { 
    this.employee.training = new EmployeeTraining()
  }

  ngOnInit(): void { 
    this.employee.training = new EmployeeTraining()
  }

  search() {
    this.successMessage = ''
    this.errorMessage = ''
    this.employee = new Employee()
    if(document.getElementById('search')!.style.display=='none') 
    this.preSearchAction()
    else {
      let employeeId = parseInt(this.searchText)
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
    setTimeout(() => {
      if(this.successMessage!='' || this.errorMessage== '')
        this.employee = new Employee()
    }, 300)
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
      button!.style.top = '9.2vh'
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

  onStatus(status: string) {
    const boxes = document.getElementsByClassName('options')
    for (let i = 0; i < boxes.length; i++) {
      (<HTMLElement>boxes[i])!.style.backgroundColor = 'transparent';
      (<HTMLElement>boxes[i])!.style.color = '#0A3F70';
    }

    const box = document.getElementById(status.toLowerCase())
    box!.style.backgroundColor = '#0A3F70'
    box!.style.color = '#fff'
    if (status == 'STARTED') {
      box!.style.borderTopRightRadius = '0px'
      box!.style.borderBottomRightRadius = '0px'
      this.employee.training.status = ETStatus.STARTED
      this.employee.training.dateCompleted = new Date()
    } else {
      box!.style.borderTopLeftRadius = '0px'
      box!.style.borderBottomLeftRadius = '0px'
      this.employee.training.status = ETStatus.COMPLETED
    }
  }

  validate(): boolean {
    this.errorMessage = ''
    this.successMessage = ''
    this.nameT = new RegExp('([A-Z][a-z]+)( [A-Z][a-z]+){0,2}').test(this.employee.name.trim()) ? false : "Please enter a valid name"
    this.locationT = new RegExp('[A-Za-z]+').test(this.employee.location.trim()) ? false : ""
    this.phone1T = new RegExp('(9|8|7|6)[0-9]{9}').test(this.employee.phone1.trim()) ? false : ""
    this.phone2T = new RegExp('(9|8|7|6)[0-9]{9}').test(this.employee.phone2.trim()) ? false : ""
    this.emailT = new RegExp('[a-z]{3,}(\\.[a-z]{3,})?([0-9]{2})?@(ad\\.)?infosys\\.com').test(this.employee.email.trim()) ? false : ""
    this.courseCodeT = new RegExp('[0-9]+').test(this.employee.training.courseCode.trim()) ? false : ""
    this.scoreT = new RegExp('[A-Z](\\+|-)?').test(this.employee.training.score.trim()) ? false : ""
    this.hoursSpentT = this.employee.training.hoursSpent > 2 ? false : ""
    // this.dateCompletedT = this.employee.training.dateCompleted.getTime() > Date.now() ? false : ""

    return (this.nameT && this.locationT && this.phone1T && this.phone2T && this.emailT && this.courseCodeT && this.scoreT && this.hoursSpentT && this.dateCompletedT) ? false : true
  }

}
