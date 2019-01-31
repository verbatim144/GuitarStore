import { Component, OnInit } from '@angular/core';
import {RegistrationService} from '../register-service/registration.service';
import {User} from '../user/user';
import {Guitar} from '../guitars/guitar';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  model: any = {};
  userRegister= new User();
  registerForm: FormGroup;
  submitted: false;

  constructor(private registrationService: RegistrationService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
  }

  createNewUser(){
    this.create();
    alert('Zostałeś zarejestrowany!\n\n');
    this.router.navigate(['/login']);
  }


  private create(): void {
    this.registrationService.registerUser(this.userRegister)
      .subscribe();
  }

}
