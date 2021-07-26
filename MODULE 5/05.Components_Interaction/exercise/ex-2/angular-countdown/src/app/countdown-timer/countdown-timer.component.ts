import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  @Input() count: number;
  @Input() countFirt: number;

  interval: any;
  constructor() { }

  ngOnInit(): void {
  }
  startCountDown() {
    this.interval = setInterval(() => {
      this.count--;
      if (this.count === 0) {
        clearInterval(this.interval);
      }
    }, 1000);
  }

  stopCount() {
    clearInterval(this.interval);
  }

  resetCuont() {
    this.count = this.countFirt;
  }
}
