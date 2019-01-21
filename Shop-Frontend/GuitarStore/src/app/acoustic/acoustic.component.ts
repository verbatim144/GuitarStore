import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';

@Component({
  selector: 'app-acoustic',
  templateUrl: './acoustic.component.html',
  styleUrls: ['./acoustic.component.css']
})
export class AcousticComponent implements OnInit {

  guitars: Guitar[];

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
