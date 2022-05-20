import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root',
})
export class InterceptorService implements HttpInterceptor {
  constructor(private loginService: LoginService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    let user = this.loginService.getUserAuth();

    if (user && req.method !== "GET") {
      req = req.clone({
        setHeaders: {
          Authorization: `Bearer ${user}`
        }
      });
      
    }
      
    return next.handle(req);
  }
}
