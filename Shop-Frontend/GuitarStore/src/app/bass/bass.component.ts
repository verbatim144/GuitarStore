import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import * as moment from 'moment';
import {OrderService} from '../order-service/order.service';

@Component({
  selector: 'app-bass',
  templateUrl: './bass.component.html',
  styleUrls: ['./bass.component.css']
})
export class BassComponent implements OnInit {

  guitars: Guitar[];
  guitarFind = new Guitar;

  constructor(private guitarService: GuitarsService,  private orderService: OrderService) { }

  ngOnInit() {
    this.getGuitars();
  }

  getGuitars() {
    return this.guitarService.getAllGuitars()
      .subscribe(
        guitars => {
          this.guitars = guitars;
        }
      );
  }


  public isLoggedIn() {
    if (localStorage.getItem('userToken') === null) {
      return true;
    } else {
      return moment().isBefore(this.getExpiration());
    }
  }

  getExpiration() {
    const expiration = localStorage.getItem('expirationDate');
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }

  getGuitarById(id: number) {
    return this.guitarService.getGuitarById(id)
      .subscribe(
        guitar => {
          this.guitarFind = guitar;
          this.orderService.addGuitar(this.guitarFind);
          /*localStorage.setItem('order', JSON.stringify(this.guitarFind));*/

        }
      );
  }

  orderClick(id: number) {
    this.getGuitarById(id);

  }
}

