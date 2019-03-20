import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Orders} from './order';
import {Guitar} from '../guitars/guitar';
import {Favourites} from '../favorite-service/favourites';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})

export class OrderService {

  private orderUrl = 'http://127.0.0.1:8080/war/order';
  order: Orders;


  constructor (
    private http: HttpClient,
  ) { }

  addOrder(order: Orders): Observable<Orders> {
    return this.http.post<Orders>(this.orderUrl, order, httpOptions);
  }

  setUsername(username: string) {
    this.order = new Orders();
    this.order.guitars = [];
    this.order.user = username;

  }

  addGuitar(guitar: Guitar) {
    this.order.guitars.push(guitar);
  }


  setTotalPrice(price: number) {
    this.order.totalPrice = price;
  }

  getOrder() {
    return this.order;
  }

}
