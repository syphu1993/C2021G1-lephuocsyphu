import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  public accountForm: FormGroup;

  countryList: string[] = ["Viet Nam","Singapo","American"];

  validateMeggage = {
    'email' : [
      {type: "required",message: "Email is not empty!"},
      {type: "email",message: "Email is not pattern!"}
    ],
    'passWord' : [
      {type: "required",message: "Password is not empty!"},
      {type: "minlength",message: "Password is wrong length!"}
    ],
    'pass' : [
      {type: "valid0",message: "Password confirm is not matches!"},
    ],
    'age' : [
      {type: "required",message: "Age is not empty!"},
      {type: "min",message: "Age is wrong min!"}
    ]
  };
  // private validateConfrim(confirmPasword: AbstractControl){
  //   let confirmPass = confirmPasword.value;
  //   if (confirmPass==pass)
  // };

  constructor() {
    this.accountForm = new FormGroup({
      email: new FormControl("",[Validators.required,Validators.email]),

      pass: new FormGroup({
        passWord: new FormControl("",[Validators.required,Validators.minLength(6)]),
        confirmPassWord: new FormControl("")
      },[this.validateConfrim]),

      country: new FormControl("",[Validators.required]),
      age: new FormControl("",[Validators.required,Validators.min(18)]),
      gender: new FormControl("",[Validators.required]),
      phone: new FormControl("",[Validators.required,Validators.pattern(" /^\\+84\\d{9,10}$/")])
    })
  }

  validateConfrim(confirmPassWord: AbstractControl): ValidationErrors|null {
    let confirmPass = confirmPassWord.value;
    if (confirmPass.passWord === confirmPass.confirmPassWord){
      return null
    }  else {
      return{'valid0': true}
    }
  };

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.accountForm);
  }
}
