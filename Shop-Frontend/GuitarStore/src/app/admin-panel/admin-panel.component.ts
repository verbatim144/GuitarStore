import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {


  guitars: Guitar[];
  testFind: Guitar;
  guitar = new Guitar();
  submitted = false;

  constructor(private guitarService: GuitarsService) { }

  ngOnInit() {
    this.getGuitars();
  }

   findGuitar(name : String){
    return this.guitarService.getGuitar(name)
      .subscribe(
        guitar => {
          console.log(guitar);
          this.testFind = guitar;
        }
      );
  }

  updateGuitar(){
    this.update();
  }

  private update(): void {
    this.guitarService.updateGuitar(this.guitar)
      .subscribe();
  }

  addGuitar() {
    this.submitted = true;
    this.save();
  }

  private save(): void {
    console.log(this.guitar);
    this.guitarService.addGuitar(this.guitar)
      .subscribe();
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

  getGuitar() {
    console.log(this.guitarService.getGuitar(name));
    return this.guitarService.getGuitar(name);

  }




}
