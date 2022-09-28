import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-p2-progress-bar',
  templateUrl: './p2-progress-bar.component.html',
  styleUrls: ['./p2-progress-bar.component.css']
})
export class P2ProgressBarComponent implements OnInit {
  @Input() backgroundColor = '#D9D9D9';
  @Input() progressColor = '#4CAF50';
  @Input() progress = 0;
  loading() {
    let interval = setInterval(() => {
      this.progress = +this.progress + 5;
      if (this.progress == 100) {
        clearInterval(interval);
      }
    }, 1000);
  }
  constructor() { }

  ngOnInit(): void {
    this.loading();
  }

}
