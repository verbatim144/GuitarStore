import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  guitars: Guitar[];
  guitarFind = new Guitar;
  guitar = new Guitar();
  submitted = false;
  identify= 0;
  sumGuitars = 0;

  constructor(private guitarService: GuitarsService) { }

  ngOnInit() {
  }


  findGuitar(name : String){
    this.identify= this.identify + 1;
    return this.guitarService.getGuitar(name)
      .subscribe(
        guitar => {
          console.log(this.guitars);
          this.guitarFind= guitar;

        }
      );
  }
}
