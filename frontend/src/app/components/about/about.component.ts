import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { User } from 'src/app/services/user.model';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  private isLogged :boolean = false;
  user!: User;
  private isEditEnabled :boolean = false;
  descripcionUser! :String;

  constructor(private portfolioServ: PortfolioService, private login :LoginService) { 

    this.login.getSession().subscribe( e => {
      if(e.tokenDeAcceso) this.isLogged = true;
    })
  }

 
  ngOnInit(): void {
    //Bring the user data to later show in the template
    this.portfolioServ.getUser().subscribe(e => {
      this.descripcionUser = e[0].descripcion;

      this.user = {
        nombre: e[0].nombre,
        apellido: e[0].apellido,
        descripcion: e[0].descripcion
      }
    });
  }

  editDescription() {
    this.isEditEnabled = !this.isEditEnabled;
  }

  getIsEditEnabled() {
    return this.isEditEnabled;
  }

  getIsLogged() {
    return this.isLogged;
  }

  editDescripcion() {
    this.isEditEnabled = !this.isEditEnabled;

    const user :User = {
      nombre: this.user.nombre,
      apellido: this.user.apellido,
      descripcion: this.descripcionUser
    }

    this.portfolioServ.editUser(9, user).subscribe(() => {
      this.user = {
        nombre: user.nombre,
        apellido: user.apellido,
        descripcion: user.descripcion
      };
    });
  }

}