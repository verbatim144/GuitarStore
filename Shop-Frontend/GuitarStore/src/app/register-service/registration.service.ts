import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../user/user';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private registerUrl = "http://127.0.0.1:8080/war/register";

  constructor (
    private http: HttpClient
  ) { }

  registerUser(user: User): Observable<User> {
    return this.http.post<User>(this.registerUrl, user, httpOptions);
  }
}
