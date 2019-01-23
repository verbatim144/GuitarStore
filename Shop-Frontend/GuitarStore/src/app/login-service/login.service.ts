import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../user/user';
import {Observable} from 'rxjs';
import * as moment from 'moment';
import {map} from 'rxjs/operators';
import {Token} from '../user/Token';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = "http://127.0.0.1:8080/war/login";

  constructor (
    private http: HttpClient
  ) { }

  loginUser(user: User): Observable<User> {
    var reqHeader = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.post<User>(this.loginUrl, user, {headers: reqHeader});
  }


  private setSession(authResult) {
    const expiresAt = moment().add(authResult.expirationDate, 'second');

    localStorage.setItem('token', authResult.token);
    localStorage.setItem('expirationDate', JSON.stringify(expiresAt.valueOf()) );
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('expirationDate');
  }

  public isLoggedIn() {
    return moment().isBefore(this.getExpiration());
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem('expirationDate');
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }

}
