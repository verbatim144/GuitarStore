import { Component, OnInit } from '@angular/core';
import {User} from '../user/user';
import {LoginService} from '../login-service/login.service';
import {HttpParams} from '@angular/common/http';
import {Token} from '../user/Token';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin = new User();

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  sendUserLogin() {
    this.send();
  }

  private send() {
    return this.loginService.loginUser(this.userLogin).subscribe(
      (data: any) => {
        localStorage.setItem('userToken', data.token);
        localStorage.setItem('expirationDate', data.expirationDate);
      }
    );
  }
}
