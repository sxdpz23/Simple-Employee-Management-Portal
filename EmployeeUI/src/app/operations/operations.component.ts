import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  public link:String = '' 

  constructor(public router: Router) { }

  ngOnInit(): void {
    this.link = this.router.url.split('/')[this.router.url.split('/').length-1]
  }

  goBack() {
    (<HTMLElement>document.getElementsByClassName('screen')[0]).style.opacity = '0'
    const backElement = document.getElementById('back')
    backElement!.style.transform = 'translate(-100%, -100%)'
    backElement!.style.opacity = '0'
    setTimeout(() => { this.router.navigate(['dashboard']) }, 800)
  }
  
}
