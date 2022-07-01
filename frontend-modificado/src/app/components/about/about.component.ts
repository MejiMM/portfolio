import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { User } from 'src/app/services/user.model';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  preserveWhitespaces: false,
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  user!: User;
  descripcionUser! :String;
  loading :boolean = false;

  constructor(private portfolioServ: PortfolioService, private login :LoginService) {     

    this.login.getSession().subscribe( e => {
      if(e.tokenDeAcceso) {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
        }, 400);
      };
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

}
