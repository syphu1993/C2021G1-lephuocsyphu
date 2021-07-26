import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-rating-bar';
  pointer: number;
  oldPointer: number;
  arr: number[] = [1,2,3,4,5,6,7,8,9,10];


  handlerClick(e): void {
    this.oldPointer = this.pointer;
    this.pointer = e.target.value;
  }

  handlerMouseOver(e): void {
    this.pointer = this.oldPointer;
  }

  handerHover(e): void {
    this.pointer = e.target.value;
  }
}
