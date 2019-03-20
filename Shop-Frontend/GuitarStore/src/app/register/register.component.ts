import { Component, OnInit } from '@angular/core';
import {RegistrationService} from '../register-service/registration.service';
import {User} from '../user/user';
import {Guitar} from '../guitars/guitar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userRegister= new User();
  submitted: false;

  constructor(private registrationService: RegistrationService) { }

  ngOnInit() {
  }

  createNewUser(){
    this.create();
  }


  private create(): void {
    this.registrationService.registerUser(this.userRegister)
      .subscribe();
  }

}
