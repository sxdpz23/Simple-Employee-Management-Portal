import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryButtons } from '../shared/models/home-buttons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = 'Employee Portal'
  buttonsList: CategoryButtons[] = [
    new CategoryButtons("Add Employee", "", "plus", "/addEmployee"),
    new CategoryButtons("View Employees", "", "users", "/viewEmployees"),
    new CategoryButtons("Update Employee Details", "", "settings", "/updateEmployeeDetails"),
    new CategoryButtons("Remove Employee", "", "x", "/deleteEmployee")
  ];

  constructor(public router: Router) { }

  ngOnInit(): void { }

  navigateTo(link: string) {
    const bottomPart = document.getElementById('bottom')
    bottomPart!.style.transform = 'translate( 0%, 100%)'
    let buttons = document.getElementsByClassName('button')
    for (let i: number = 0; i < buttons.length; i++) {
      (<HTMLElement>buttons[i]).style.opacity = '0'
    }
    document.getElementById('top')!.style.opacity = '0'
    setTimeout(() => {
      bottomPart!.style.display = 'none'
      document.getElementById('divider')!.style.display = 'none'
    }, 1000)
    
    setTimeout(() => { this.router.navigate(['dashboard' + link]) }, 1100)
  }

}
