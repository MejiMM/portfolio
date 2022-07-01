import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-control',
  templateUrl: './control.component.html',
  styleUrls: ['./control.component.css']
})
export class ControlComponent implements OnInit {

  isLogged :boolean = true;

  constructor( private login :LoginService ) { }

  ngOnInit(): void {
    this.login.currentUserSubject.asObservable().subscribe(e => {
      if(e.tokenDeAcceso) this.isLogged = false
    });
  }

}
