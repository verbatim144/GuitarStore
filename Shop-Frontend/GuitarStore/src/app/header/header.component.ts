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

  guitars: Guitar[];
  guitarFind = new Guitar;
  role: string;


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

  public isLoggedOut() {
    if (localStorage.getItem('userToken') == null && moment().isBefore(this.getExpiration()) == false) {
      return true;
    } else {
      return false
    }
  }


  getExpiration() {
    const expiration = localStorage.getItem('expirationDate');
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }

  public isAdmin(){
    if(!this.isLoggedOut()){
      if (localStorage.getItem('role') == null || localStorage.getItem('role') == "USER"){
        return false;
      }else {
        return true;
      }
    }
    return false;
  }

}
