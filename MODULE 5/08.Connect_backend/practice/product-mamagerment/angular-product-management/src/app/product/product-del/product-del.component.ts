import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product-del',
  templateUrl: './product-del.component.html',
  styleUrls: ['./product-del.component.css']
})
export class ProductDelComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ProductDelComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private productService: ProductService
  ) { }
  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

}
