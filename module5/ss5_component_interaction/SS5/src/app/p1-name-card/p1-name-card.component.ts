import {Component, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-p1-name-card',
  templateUrl: './p1-name-card.component.html',
  styleUrls: ['./p1-name-card.component.css']
})
export class P1NameCardComponent implements OnInit {
  @Input() cardName : string;
  @Input() email: string;
  @Input() phone: string;
  constructor() { }

  ngOnInit(): void {
  }

}
