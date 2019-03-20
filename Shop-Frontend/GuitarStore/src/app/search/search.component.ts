import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import {HeaderComponent} from '../header/header.component';
import {identity} from 'rxjs';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  guitars: Guitar[];
  guitarFind = new Guitar;
  guitar = new Guitar();
  submitted = false;

  constructor(private guitarService: GuitarsService) { }

  ngOnInit() {

  }

  findGuitar(name : String){
    return this.guitarService.getGuitar(name)
      .subscribe(
        guitar => {
          console.log(this.guitars);
          this.guitarFind= guitar;

        }
      );
  }

}
