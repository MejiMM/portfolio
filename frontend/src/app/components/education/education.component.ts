import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Educacion } from 'src/app/services/educacion.model';
import { LoginService } from 'src/app/services/login.service';
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
  form :FormGroup;  
  formEd :boolean = false;
  loading :boolean = false;
  
  constructor(private portfolioServ :PortfolioService, private login :LoginService, private formBuilder :FormBuilder) {

    //Bring the elements of education to be displayed
    this.portfolioServ.getEducacion().subscribe( e => {

      this.educacions = e; 
    });

    //The constructor for the form fields
    this.form = this.formBuilder.group({
      lugar: ["", Validators.required],
      titulo: ["", Validators.required],
      urlCert: [""]
    });

    //Detect changes in the token to render the portfolio edition
    this.login.getSession().subscribe(e => {
      if(e.tokenDeAcceso) {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
        }, 400);
        this.isLogged = true;
      }
    });
  }
  
  ngOnInit(): void { }

  //Change the edition of the education section according to the user who is logged in
  toggleFormEd() {
    this.formEd = !this.formEd;    
  }

  addEducacion() {

    const educacion :Educacion = {
      lugar: this.form.get("lugar")?.value,
      titulo: this.form.get("titulo")?.value,
      urlCert: this.form.get("urlCert")?.value
    }

    this.formEd = false;

    this.portfolioServ.addEd(educacion).subscribe( e => { 
      this.educacions.push(e);
    });

  }

  deleteEducacion(id :number) :void {
    this.portfolioServ.deleteEd(id).subscribe( e => this.educacions = e);
  }

}
