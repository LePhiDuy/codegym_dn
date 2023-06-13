import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {E1RatingBarComponent} from "./e1-rating-bar/e1-rating-bar.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit{
  title = 'SS5';
  name:string = "ABCD";
  phone:string = "035123456";
  email:string = "duyphi000@gmail.com";
  @ViewChild(E1RatingBarComponent) e1: E1RatingBarComponent;

  ngAfterViewInit(): void {
    console.log(this.e1.a);
  }
}
