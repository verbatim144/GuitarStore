import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Guitar} from './guitar';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})


export class GuitarsService {
  private guitarUrl = 'http://127.0.0.1:8080/war/guitar';

  constructor (
    private http: HttpClient
  ) { }


  getAllGuitars (): Observable<Guitar[]> {

    return this.http.get<Guitar[]>(this.guitarUrl);
  }

getGuitar(name: String): Observable<Guitar> {
  const url = `${this.guitarUrl + '/name'}/${name}`;
  console.log(url);
return this.http.get<Guitar>(url);
}

  getGuitarById(id: number): Observable<Guitar> {
    const url = `${this.guitarUrl}/${id}`;
    return this.http.get<Guitar>(url);
  }

addGuitar(guitar: Guitar): Observable<Guitar> {
  return this.http.post<Guitar>(this.guitarUrl, guitar, httpOptions);
}

deleteGuitar(id: number): Observable<Guitar> {
  const url = `${this.guitarUrl}/${id}`;
    return this.http.delete<Guitar>(url, httpOptions);
  }

updateGuitar(guitar: Guitar): Observable<Guitar> {
    return this.http.put<Guitar>(this.guitarUrl, guitar, httpOptions);
  }
}
