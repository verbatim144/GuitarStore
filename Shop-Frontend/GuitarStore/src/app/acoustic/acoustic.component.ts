import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import * as moment from 'moment';
import {OrderService} from '../order-service/order.service';
import {Orders} from '../order-service/order';


@Component({
  selector: 'app-acoustic',
  templateUrl: './acoustic.component.html',
  styleUrls: ['./acoustic.component.css']
})
export class AcousticComponent implements OnInit {

  guitars: Guitar[];
  order = new Orders();

  constructor(private guitarService: GuitarsService, private orderService: OrderService) { }

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

  public addOrder() {
    this.add();
  }

  private add(): void {
    this.orderService.addOrder(this.order)
      .subscribe();
  }

  orderClick(category: string,) {
    this.order.guitars = this.guitars;
  }


}
