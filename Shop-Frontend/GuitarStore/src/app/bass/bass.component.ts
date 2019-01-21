import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';

@Component({
  selector: 'app-bass',
  templateUrl: './bass.component.html',
  styleUrls: ['./bass.component.css']
})
export class BassComponent implements OnInit {

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
