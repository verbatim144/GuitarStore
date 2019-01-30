import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Guitar} from '../guitars/guitar';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class StatsService {

  private orderStatsUrl = 'http://127.0.0.1:8080/war/stats/orders';

  constructor(private http: HttpClient) { }

  getGuitar() {
    const url = `${this.orderStatsUrl}`;
    return this.http.get(url);
  }
}
