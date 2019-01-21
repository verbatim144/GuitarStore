import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import { Location } from '@angular/common';
import {Category} from '../categories/category';
import {CategoryService} from '../categories/category.service';


@Component({
  selector: 'app-electric',
  templateUrl: './electric.component.html',
  styleUrls: ['./electric.component.css']
})
export class ElectricComponent implements OnInit {

  guitars: Guitar[];
  guitar = new Guitar();
  categories: Category[];
  category= new Category();
  submitted = false;


  constructor(private guitarService: GuitarsService,
              private categoryService: CategoryService,
              private location: Location) { }

  ngOnInit(): void {
   this.getGuitars();
  }

  newGuitar(): void {
    this.submitted = false;
    this.guitar = new Guitar();
  }

  addGuitar() {
    this.submitted = true;
    this.save();
  }

  getGuitars() {
    return this.guitarService.getAllGuitars()
      .subscribe(
        guitars => {
          this.guitars = guitars;
        }
      );
  }

  onSelect(selectedItem: any) {
    console.log("Selected item Id: ", selectedItem.Id); // You get the Id of the selected item here
  }

  /*getGuitarCategory() {
    return this.categoryService.getCategory("electric")
      .subscribe(
        guitarCategory => {
          console.log(guitarCategory );
          this.category = guitarCategory ;
        }
      );
  }*/


//  refresh(): void {
 //   window.location.reload();
 // }

  private save(): void {
    console.log(this.guitar);
    this.guitarService.addGuitar(this.guitar)
      .subscribe();
  }



}
