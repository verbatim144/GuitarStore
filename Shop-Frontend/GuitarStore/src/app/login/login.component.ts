import { Component, OnInit } from '@angular/core';
import {User} from '../user/user';
import {LoginService} from '../login-service/login.service';
import {Router, RouterModule} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin = new User();

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }


  sendUserLogin() {
    this.sendUser();
  }

  private sendUser() {
     return this.loginService.loginUser(this.userLogin).subscribe(
       (data: any) => {
      localStorage.setItem('userToken', data.token);
      localStorage.setItem('role', data.userRole);
      localStorage.setItem('order', data.username);
      this.router.navigate(['/landing']);
    });
  }


}
