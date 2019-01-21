import { Component, OnInit } from '@angular/core';
import {Guitar} from '../guitars/guitar';
import {GuitarsService} from '../guitars/guitars.service';
import {Chart} from  'chart.js'


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
  public pieChartLabels:string[] = ['Download Sales', 'In-Store Sales', 'Mail Sales'];
  public pieChartData:number[] = [300, 500, 100];
  public pieChartType:string = 'pie';

  constructor(private guitarService: GuitarsService) { }

  ngOnInit() {
    this.getGuitars();

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
          console.log(guitars);
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
