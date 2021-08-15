import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeTraining } from 'src/app/shared/models/employeeTraining';
import { ETStatus } from 'src/app/shared/models/etStatus';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  employeeToAdd: Employee = new Employee();
  errorMessage!: String
  successMessage!: String
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
    this.employeeToAdd.training = new EmployeeTraining()
  }

  ngOnInit(): void {
    this.employeeToAdd.training = new EmployeeTraining()
  }

  addEmployee() {
    this.employeeToAdd.training.emailId = this.employeeToAdd.email
    if (this.validate()) {
      console.log(this.employeeToAdd)
      this.service.addService(this.employeeToAdd!).subscribe(response => {
        this.successMessage = response;
        let id = this.successMessage.substring(0, this.successMessage.indexOf(':') + 1).trim();
        this.employeeToAdd!.employeeId = parseInt(id)
      }, error => this.errorMessage = error);
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
      this.employeeToAdd.training.status = ETStatus.STARTED
      this.employeeToAdd.training.dateCompleted = new Date()
    } else {
      box!.style.borderTopLeftRadius = '0px'
      box!.style.borderBottomLeftRadius = '0px'
      this.employeeToAdd.training.status = ETStatus.COMPLETED
    }
  }

  validate(): boolean {
    this.errorMessage = ''
    this.successMessage = ''
    this.nameT = new RegExp('([A-Z][a-z]+)( [A-Z][a-z]+){0,2}').test(this.employeeToAdd.name.trim()) ? false : "Please enter a valid name"
    this.locationT = new RegExp('[A-Za-z]+').test(this.employeeToAdd.location.trim()) ? false : ""
    this.phone1T = new RegExp('(9|8|7|6)[0-9]{9}').test(this.employeeToAdd.phone1.trim()) ? false : ""
    this.phone2T = new RegExp('(9|8|7|6)[0-9]{9}').test(this.employeeToAdd.phone2.trim()) ? false : ""
    this.emailT = new RegExp('[a-z]{3,}(\\.[a-z]{3,})?([0-9]{2})?@(ad\\.)?infosys\\.com').test(this.employeeToAdd.email.trim()) ? false : ""
    this.courseCodeT = new RegExp('[0-9]+').test(this.employeeToAdd.training.courseCode.trim()) ? false : ""
    this.scoreT = new RegExp('[A-Z](\\+|-)?').test(this.employeeToAdd.training.score.trim()) ? false : ""
    this.hoursSpentT = this.employeeToAdd.training.hoursSpent > 2 ? false : ""
    // this.dateCompletedT = this.employeeToAdd.training.dateCompleted.getTime() > Date.now() ? false : ""

    return (this.nameT && this.locationT && this.phone1T && this.phone2T && this.emailT && this.courseCodeT && this.scoreT && this.hoursSpentT && this.dateCompletedT) ? false : true
  }

}
