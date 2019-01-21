import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../user/user';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

let key = 'Item 1';
localStorage.setItem(key, 'Value');

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = "http://127.0.0.1:8080/war/login";

  constructor (
    private http: HttpClient
  ) { }

  loginUser(user: User): Observable<User> {
    let myItem = localStorage.getItem(key);
    console.log(myItem)
    return this.http.post<User>(this.loginUrl, user, httpOptions)
      .pipe(map(user =>{
        if(user) {
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        return user;
      }));
  }
}
