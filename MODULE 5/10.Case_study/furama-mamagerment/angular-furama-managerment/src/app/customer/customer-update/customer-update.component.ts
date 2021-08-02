import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {CustomerTypeService} from "../../service/cutomer-type.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../../module/customer-type";

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {
  customerForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    code: new FormControl(),
    birthday: new FormControl(),
    idCard: new FormControl(),
    phone: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    type: new FormControl()
  });
  public type: CustomerType[];
  constructor(public dialogRef: MatDialogRef<CustomerUpdateComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private customerService: CustomerService,
              private customerTypeService: CustomerTypeService) { }

  ngOnInit(): void {
    this.getAllType();
    this.customerForm.patchValue(this.data)
  }
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
  getAllType(){
    this.customerTypeService.findAll().subscribe(next=>{
      this.type = next;
    })
  }

  submit() {
    const customer =  this.customerForm.value;
    this.customerService.updateCustomer(customer.id,customer).subscribe(next => {
      this.dialogRef.close(true);
    });
  }
}
