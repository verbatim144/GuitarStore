import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import {Chart} from  'chart.js'
import {Router} from '@angular/router';
import {StatsService} from '../stats/stats.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {


  guitars: Guitar[];
  guitarFind = new Guitar;
  guitar = new Guitar();
  submitted = false;
  identify= 0;
  sumGuitars = 0;
  electricGuitarsSum = 0;
  classicGuitarSum = 0;
  acousticGuitarSum = 0;
  bassGuitarSum = 0;

  constructor(private guitarService: GuitarsService,
              private router : Router,
              private statsService: StatsService) { }

  ngOnInit() {
    this.getGuitars();
    this.sumGuitarsQuantity()
    this.sumOfGuitarCategory();
    console.log(this.statsService.getGuitar());

  }

  public pieChartLabels:string[] = ["Elektryczne", "Klasyczne", "Akustyczne", "Basowe"];
  public pieChartData:number[] = [0,0,0,0];
  public pieChartType:string = 'pie';

   findGuitar(name : String){
    this.identify= this.identify + 1;
    return this.guitarService.getGuitar(name)
      .subscribe(
        guitar => {
          this.guitarFind= guitar;

        }
      );
  }

  sumOfGuitarCategory() {
    this.guitarService.getAllGuitars()
      .subscribe(
        guitars => {
          this.guitars = guitars;
          for (let i = 0; i < this.guitars.length; i++) {
            if (this.guitars[i].category == 'Electric') {
              this.electricGuitarsSum = this.electricGuitarsSum + this.guitars[i].quantity;
              console.log(this.electricGuitarsSum)
            } else {
              if (this.guitars[i].category == 'Classic') {
                this.classicGuitarSum = this.classicGuitarSum + this.guitars[i].quantity;
                console.log(this.classicGuitarSum)
              } else {
                if (this.guitars[i].category == 'Acoustic') {
                  this.acousticGuitarSum = this.acousticGuitarSum + this.guitars[i].quantity;
                } else {
                  if (this.guitars[i].category == 'Bass') {
                    this.bassGuitarSum = this.bassGuitarSum + this.guitars[i].quantity;
                  }
                }
              }
            }
          }
         this.pieChartData = [this.classicGuitarSum, this.electricGuitarsSum, this.acousticGuitarSum, this.bassGuitarSum ];
        });

  }

  sumGuitarsQuantity(){
    this.guitarService.getAllGuitars()
      .subscribe(
        guitars => {
          this.guitars = guitars;
          for (let i = 0; i < this.guitars.length; i++) {
            this.sumGuitars = this.sumGuitars + this.guitars[i].quantity
          }
        }
      );

  }

  updateGuitar(){
    this.update();
  }

  private update(): void {
    this.guitarService.updateGuitar(this.guitarFind)
      .subscribe();
  }

  addGuitar() {
    this.guitar.id = 1;
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
          this.guitars = guitars;
        }
      );
  }

  deleteGuitar() {
    this.delete();
  }

  private delete(): void {
    this.guitarService.deleteGuitar(this.guitarFind.id)
      .subscribe();
  }




}
