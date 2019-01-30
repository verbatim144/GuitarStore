import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {ShoppingCartServiceService} from '../shopping-cart-service/shopping-cart-service.service';
import {Cart} from '../shopping-cart-service/cart';
import {OrderService} from '../order-service/order.service';
import {AppGlobals} from '../app.global';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css'],
  providers: [ AppGlobals]
})
export class ShoppingCartComponent implements OnInit {

  guitars: Guitar[];
  cart: Cart[];

  constructor(private shoppingService: ShoppingCartServiceService, private orderService: OrderService) { }

  ngOnInit(): void {
  }

  getGuitars() {
    return this.shoppingService.getAllProducts()
      .subscribe(
        products => {
          this.cart = products;
          console.log(this.cart);

        }
      );
  }




}
