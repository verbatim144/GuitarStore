import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';

@Component({
  selector: 'app-classic',
  templateUrl: './classic.component.html',
  styleUrls: ['./classic.component.css']
})
export class ClassicComponent implements OnInit {

  guitars : Guitar[];

  constructor(private guitarService: GuitarsService) { }

  ngOnInit() {
    this.getGuitars();
  }


  getGuitars() {
    return this.guitarService.getAllGuitars()
      .subscribe(
        guitars => {
          this.guitars = guitars;
        }
      );
  }
}
