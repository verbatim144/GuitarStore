import { Component, OnInit } from '@angular/core';
import {User} from '../user/user';
import {LoginService} from '../login-service/login.service';

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


  sendUserLogin(){
    this.send();
  }

  private send(): void {
    this.loginService.loginUser(this.userLogin)
      .subscribe(
        res => {
          localStorage.setItem("token", res.token)
        },
      )
  }


}
