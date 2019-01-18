import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from './category';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  name:String;
  private categoryUrl = 'http://127.0.0.1:8080/war/category/';
  constructor(
    private http: HttpClient
  ) { }

  getCategory (name: String): Observable<Category> {
    return this.http.get<Category>(this.categoryUrl+name);
  }

  /*getGuitarsSet(name: string): Observable<Category> {
    const url = `${this.categoryUrl}/${name}`;
    return this.http.get<Category>(url);
  }*/
  
}
