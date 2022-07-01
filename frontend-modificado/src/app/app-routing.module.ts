import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { WelcomeGuard } from './welcome.guard';
import { ControlComponent } from './components/control/control.component';

const routes: Routes = [
  {path: "home", component: HeaderComponent, pathMatch: "full" ,canActivate: [WelcomeGuard]},
  {path: "admin", component: ControlComponent, pathMatch: "full"},
  {path: "**", component: WelcomeComponent}
];

@NgModule({
  imports: [ CommonModule, RouterModule.forRoot(routes, {
    initialNavigation: 'enabledBlocking'
})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
