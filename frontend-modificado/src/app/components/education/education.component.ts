import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  preserveWhitespaces: false,
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  
  educacions :any = [];
  isLogged :boolean = false;
  formEd :boolean = false;
  loading :boolean = false;
  
  constructor(private portfolioServ :PortfolioService) {

    //Bring the elements of education to be displayed
    this.portfolioServ.getEducacion().subscribe( e => {

      this.educacions = e; 
    });
  }
  
  ngOnInit(): void { }

}
