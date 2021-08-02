import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {MatDialog} from "@angular/material/dialog";
import {ProductDelComponent} from "../product-del/product-del.component";
import {Router} from "@angular/router";
import {ProductUpdateComponent} from "../product-update/product-update.component";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  public products: Product[]=[];
  public category: Category[];
  config: any;
  constructor(private productService: ProductService,
              private catelogyService: CategoryService,
              public dialog: MatDialog,
              private router: Router) {
    this.config = {
      itemsPerPage: 3,
      currentPage: 1,
      totalItems: this.products.length
    };
  }

  ngOnInit(): void {
    this.getFindAll();
    this.getFindAllCategory();
  }
  getFindAll(){
    this.productService.findAllProduct().subscribe(next =>{
      this.products= next;
    });
  }
  getFindAllCategory(){
    this.catelogyService.findAllCategory().subscribe(next=>{
      this.category = next;
      console.log(this.category)
    })
  }
  onDeleteHandler(id): void {
    let dialogRef = this.dialog.open(ProductDelComponent, {
      width: '300px',
      height:'150px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result){
        this.productService.deleteProduct(id).subscribe(next =>{
          this.getFindAll();
        });
      }
    });
  }

  onUpdateProductHandler(product: Product) {
    let dialogRef = this.dialog.open(ProductUpdateComponent, {
      width: '500px',
      data: product,
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result){
        this.getFindAll();
      }
    });
  }
  pageChanged(event){
    this.config.currentPage = event;
  }
}
