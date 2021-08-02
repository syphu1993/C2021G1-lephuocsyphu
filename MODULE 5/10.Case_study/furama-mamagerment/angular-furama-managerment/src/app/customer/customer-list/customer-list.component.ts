import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../module/customer";
import {MatDialog} from "@angular/material/dialog";
import {CustomerUpdateComponent} from "../customer-update/customer-update.component";
import {CustomerDelComponent} from "../customer-del/customer-del.component";
import {CustomerCreateComponent} from "../customer-create/customer-create.component";
import {CustomerType} from "../../module/customer-type";
import {CustomerTypeService} from "../../service/cutomer-type.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  config: any;
  searchText = "";
  searchText1 = "";
  searchText2 = "";
  type: CustomerType[];
  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              public dialog: MatDialog,) {
    this.config = {
      itemsPerPage: 3,
      currentPage: 1,
      totalItems: this.customers.length
    };
  }

  ngOnInit(): void {
    this.findAllCustomer();
    this.findAllType();
  }
  pageChanged(event){
    this.config.currentPage = event;
  }
  findAllCustomer(){
    this.customerService.findAll().subscribe(next=>{
      this.customers = next;
    })
  }

  findAllType(){
    this.customerTypeService.findAll().subscribe(next=>{
      this.type = next;
    })
  }

  onUpdateCustomerHandler(cus: Customer) {
    let dialogRef = this.dialog.open(CustomerUpdateComponent, {
      width: '500px',
      data: cus,
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result){
        this.findAllCustomer();
      }
    });
  }

  onDeleteHandler(id: number) {
    let dialogRef = this.dialog.open(CustomerDelComponent, {
      width: '300px',
      data: id,
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result){
        this.customerService.deleteCustomer(id).subscribe(next =>{
          this.findAllCustomer();
        });
      }
    });
  }

  onCreateCustomerHandler() {
    let dialogRef = this.dialog.open(CustomerCreateComponent, {
      width: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result){
        this.findAllCustomer();
      }
    });
  }

  searchCustomer() {
  this.customerService.search(this.searchText,this.searchText1,this.searchText2).subscribe(next=>{
    this.customers = next;
  })
  }
}
