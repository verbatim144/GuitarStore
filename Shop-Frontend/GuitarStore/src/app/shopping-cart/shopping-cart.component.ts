import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {Category} from '../categories/category';
import {GuitarsService} from '../guitars/guitars.service';
import {CategoryService} from '../categories/category.service';
import {Location} from '@angular/common';
import {ShoppingCartServiceService} from '../shopping-cart-service/shopping-cart-service.service';
import {Cart} from '../shopping-cart-service/cart';
import {Orders} from '../order-service/order';
import {OrderService} from '../order-service/order.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  products: Cart[];
  order: Orders;

  constructor(private shoppingService: ShoppingCartServiceService, private orderService: OrderService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    return this.shoppingService.getAllProducts()
      .subscribe(
        products => {
          this.products = products;
        }
      );
  }

  addOrder() {
    this.save();
  }

  private save(): void {
    console.log(this.order);
    this.orderService.addOrder(this.order)
      .subscribe();
  }



}
