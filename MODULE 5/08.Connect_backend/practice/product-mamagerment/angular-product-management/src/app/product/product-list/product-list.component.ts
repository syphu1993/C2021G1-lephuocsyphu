import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {MatDialog} from "@angular/material/dialog";
import {ProductDelComponent} from "../product-del/product-del.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  public products: Product[];
  constructor(private productService: ProductService,
              public dialog: MatDialog,
              private router: Router) { }

  ngOnInit(): void {
    this.getFindAll();
  }
  getFindAll(){
    this.productService.findAllProduct().subscribe(next =>{
      this.products= next;
    });
  }
  onDeleteHandler(id): void {
    let dialogRef = this.dialog.open(ProductDelComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if (result){
        this.productService.deleteProduct(id).subscribe(next =>{
          this.getFindAll();
        });
      }
    });
  }
}
