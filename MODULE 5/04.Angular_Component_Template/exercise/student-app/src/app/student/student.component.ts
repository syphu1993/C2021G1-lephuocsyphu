import { Component, OnInit } from '@angular/core';
import {Student} from "../model/student";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students: Student[] = [
    new Student(1,"nam","12/12/2000",7),
    new Student(2,"ha","11/12/2000",9),
    new Student(3,"son","10/12/2000",5)
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
