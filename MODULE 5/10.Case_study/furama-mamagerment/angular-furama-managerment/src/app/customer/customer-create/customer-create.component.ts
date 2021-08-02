import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../../module/customer-type";
import {CustomerService} from "../../service/customer.service";
import {CustomerTypeService} from "../../service/cutomer-type.service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl("",[Validators.required,Validators.minLength(3)]),
    code: new FormControl("",[Validators.required,Validators.minLength(3)]),
    birthday: new FormControl("",[Validators.required,Validators.minLength(3)]),
    idCard: new FormControl("",[Validators.required,Validators.minLength(3)]),
    phone: new FormControl("",[Validators.required,Validators.minLength(3)]),
    email: new FormControl("",[Validators.required,Validators.email]),
    address: new FormControl("",[Validators.required]),
    type: new FormControl("",[Validators.required])
  });
  type: CustomerType[];
  constructor(
              public dialogRef: MatDialogRef<CustomerCreateComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,private customerService: CustomerService,
              private cutomerTypeService: CustomerTypeService,
              private router: Router) { }

  ngOnInit(): void {
    this.findAllType();
  }
  findAllType(){
    this.cutomerTypeService.findAll().subscribe(next=>{
      this.type = next;
    })
  }

  submit() {
    if (this.customerForm.valid){
      this.customerService.createCustomer(this.customerForm.value).subscribe(next => {
          this.dialogRef.close(true);
        }
      )
    }else {
      alert("Form error!")
    }
  }
}
