import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Orders} from './order';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})

export class OrderService {

  private orderUrl = "http://127.0.0.1:8080/war/shoppingCart";

  constructor (
    private http: HttpClient
  ) { }

  addOrder(order: Orders): Observable<Orders> {
    return this.http.post<Orders>(this.orderUrl, order, httpOptions);
  }


}
