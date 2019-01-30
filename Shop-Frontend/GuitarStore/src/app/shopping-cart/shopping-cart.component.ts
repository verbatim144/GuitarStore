import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {ShoppingCartServiceService} from '../shopping-cart-service/shopping-cart-service.service';
import {Cart} from '../shopping-cart-service/cart';
import {OrderService} from '../order-service/order.service';
import {AppGlobals} from '../app.global';
import {Orders} from '../order-service/order';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css'],
  providers: [ AppGlobals]
})
export class ShoppingCartComponent implements OnInit {

  guitars: Guitar[];
  cart: Cart[];
  orders: Orders;
  totalsum = 0;

  constructor(private shoppingService: ShoppingCartServiceService, private orderService: OrderService) { }

  ngOnInit(): void {
    this.orders = this.orderService.getOrder();
    this.totalSumOrder();
  }

  onItemDeleted(index) {
    this.totalsum = this.totalsum - this.orders.guitars[index].price;
    this.orders.guitars.splice(index, 1);
  }

  onAllDeleted() {
    this.orders.guitars = [];
    this.totalsum = 0;
  }

  addOrder() {
    this.save();
    this.onAllDeleted();
  }

  private save(): void {
    this.orderService.setTotalPrice(this.totalsum);
    this.orderService.addOrder(this.orders)
      .subscribe();
  }

  totalSumOrder() {
    for (let i = 0; i < this.orders.guitars.length; i++) {
      this.totalsum = this.totalsum + this.orders.guitars[i].price;
    }
  }

}
