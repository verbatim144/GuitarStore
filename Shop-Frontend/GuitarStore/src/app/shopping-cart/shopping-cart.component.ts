import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {Category} from '../categories/category';
import {GuitarsService} from '../guitars/guitars.service';
import {CategoryService} from '../categories/category.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  guitars: Guitar[];
  guitar = new Guitar();
  submitted = false;


  constructor(private guitarService: GuitarsService,
              private categoryService: CategoryService,
              private location: Location) { }

  ngOnInit(): void {
    this.getGuitars();
  }


  getGuitars() {
    return this.guitarService.getAllGuitars()
      .subscribe(
        guitars => {
          console.log(guitars);
          this.guitars = guitars;
        }
      );
  }



}
