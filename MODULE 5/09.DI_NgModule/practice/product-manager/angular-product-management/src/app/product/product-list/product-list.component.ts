import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {MatDialog} from "@angular/material/dialog";
import {ProductUpdateComponent} from "../product-update/product-update.component";
import {ProductDelComponent} from "../product-del/product-del.component";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(private productService: ProductService,public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.products = this.productService.getAll();
  }

  onDeleteHandler(id): void {
    let dialogRef = this.dialog.open(ProductDelComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed')
      if (result){
        this.productService.deleteProduct(id);
      }
    });
  }

  onUpdateProductHandler(product): void {
    let dialogRef = this.dialog.open(ProductUpdateComponent, {
      width: '500px',
      data: product
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result){
      }
    });
  }

}
