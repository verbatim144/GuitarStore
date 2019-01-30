import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {Category} from '../categories/category';
import {GuitarsService} from '../guitars/guitars.service';
import {CategoryService} from '../categories/category.service';
import {Location} from '@angular/common';
import {OrderService} from '../order-service/order.service';
import {Cart} from '../shopping-cart-service/cart';
import {Orders} from '../order-service/order';
import {ShoppingCartServiceService} from '../shopping-cart-service/shopping-cart-service.service';
import {Favourites} from '../favorite-service/favourites';
import {FavoriteService} from '../favorite-service/favorite-service.service';


@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {

  guitars: Guitar[];
  cart: Cart[];
  orders: Orders;
  favourite: Favourites;
  totalsum = 0;

  constructor(private shoppingService: ShoppingCartServiceService, private favouriteService: FavoriteService) { }

  ngOnInit(): void {
    this.favourite = this.favouriteService.getFavourite();
  }

  onItemDeleted(index) {
    this.totalsum = this.totalsum - this.orders.guitars[index].price;
    this.orders.guitars.splice(index, 1);
  }

  onAllDeleted() {
    this.orders.guitars = [];
    this.totalsum = 0;
  }



}
