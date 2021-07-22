import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  first: number;
  second: number;
  output: number;
  operator: string;

  constructor() { }

  ngOnInit(): void {
  }
  onfirstChange(value){
    this.first = Number(value);
  }
  onsecondChange(value){
    this.second = Number(value);
  }
  onselectChange(value){
    this.operator =value;
  }
  caculate(){
    switch (this.operator) {
      case '+': this.output = this.first + this.second;
                break;
      case '-': this.output = this.first - this.second;
        break;
      case '*': this.output = this.first * this.second;
        break;
      case '/': this.output = this.first / this.second;
        break;
    }
  }
}
