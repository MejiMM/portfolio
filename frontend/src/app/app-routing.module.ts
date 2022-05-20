import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { WelcomeGuard } from './welcome.guard';

const routes: Routes = [
  {path: "", component: WelcomeComponent},
  {path: "home", component: HeaderComponent, canActivate: [WelcomeGuard]}
];

@NgModule({
  imports: [ CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
