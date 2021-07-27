import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup;
  constructor() {
    this.loginForm = new FormGroup({
      email: new FormControl("",[Validators.required,Validators.email]),
      passWord: new FormControl("",[Validators.required,Validators.minLength(6)])
    })
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.loginForm.value);
  }
}
