import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import { Location } from '@angular/common';
import {Category} from '../categories/category';
import {CategoryService} from '../categories/category.service';
import * as moment from 'moment';
import {OrderService} from '../order-service/order.service';


@Component({
  selector: 'app-electric',
  templateUrl: './electric.component.html',
  styleUrls: ['./electric.component.css']
})
export class ElectricComponent implements OnInit {

  guitars: Guitar[];
  guitar = new Guitar();
  category = new Category();
  guitarFind = new Guitar;


  constructor(private guitarService: GuitarsService,
              private categoryService: CategoryService,
              private location: Location,
              private orderService: OrderService) { }

  ngOnInit(): void {
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
    if(localStorage.getItem('userToken') === null) {
      return true;
    }else{
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
