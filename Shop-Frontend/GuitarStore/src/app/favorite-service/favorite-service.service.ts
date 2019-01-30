import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Guitar} from '../guitars/guitar';
import {Favourites} from '../favorite-service/favourites';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})

export class FavoriteService {

  favourite: Favourites;

  constructor (
    private http: HttpClient,
  ) { }

  setUsernameFavourite(username: string) {
    this.favourite = new Favourites();
    this.favourite.guitars = [];
    this.favourite.user = username;
  }

  addGuitarFavourite(guitar: Guitar) {
    this.favourite.guitars.push(guitar);
  }

  getFavourite() {
    return this.favourite;
  }

}
