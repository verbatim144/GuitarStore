import { Component, OnInit } from '@angular/core';
import {User} from '../user/user';
import {LoginService} from '../login-service/login.service';
import {Router, RouterModule} from '@angular/router';
import {Orders} from '../order-service/order';
import {OrderService} from '../order-service/order.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin = new User();
  orders = new Orders();

  constructor(private loginService: LoginService, private router: Router, private orderService: OrderService) { }

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
         localStorage.setItem('username', data.username);
         console.log(this.orders);
         this.orderService.addOrder(this.orders);
         this.orderService.setUsername(localStorage.getItem('username'));
      this.router.navigate(['/landing']);
    });
  }

}
