import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import * as moment from 'moment';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public identify = 0;

  guitars: Guitar[];
  guitarFind = new Guitar;
  submitted: boolean = false;


  constructor(private guitarService: GuitarsService) { }

  ngOnInit() {
  }

  findGuitar(name : String){
    return this.guitarService.getGuitar(name)
      .subscribe(
        guitar => {
          this.guitarFind= guitar;
        }
      );
  }

  logout() {
    localStorage.removeItem('userToken');
    localStorage.removeItem('expirationDate');
  }

  public isLoggedIn() {
    if(localStorage.getItem('userToken')==null){
      return true;
    }else{
    return moment().isBefore(this.getExpiration());
    }
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem('expirationDate');
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }


}
