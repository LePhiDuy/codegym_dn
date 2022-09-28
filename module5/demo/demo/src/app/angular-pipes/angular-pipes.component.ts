import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-pipes',
  templateUrl: './angular-pipes.component.html',
  styleUrls: ['./angular-pipes.component.css']
})
export class AngularPipesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  dataStr:string = "Lee Phi Duy";
  dataNumber:number = 200.5;
  dataCur:number = 200000;
  dataDate:Date = new Date();
}
