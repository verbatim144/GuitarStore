import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cart} from './cart';
import {Guitar} from '../guitars/guitar';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class ShoppingCartServiceService {

  private cartUrl = "http://127.0.0.1:8080/war/shoppingCart";

  constructor (
    private http: HttpClient
  ) { }

  getAllProducts (): Observable<Cart[]> {
    return this.http.get<Cart[]>(this.cartUrl);
  }

  addToCart(cart: Cart): Observable<Cart> {
    return this.http.post<Cart>(this.cartUrl, cart, httpOptions);
  }

  deleteProduct(id: number): Observable<Cart> {
    const url = `${this.cartUrl}/${id}`;
    return this.http.delete<Cart>(url, httpOptions);
  }

  updateProduct(cart: Cart): Observable<Cart> {
    return this.http.put<Cart>(this.cartUrl, cart, httpOptions);
  }

}
