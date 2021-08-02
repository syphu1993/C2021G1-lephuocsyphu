import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });
  public category: Category[];
  constructor(public dialogRef: MatDialogRef<ProductUpdateComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.productForm.patchValue(this.data);
    this.getFindAllCategory();
  }
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
  getFindAllCategory(){
    this.categoryService.findAllCategory().subscribe(next=>{
      this.category = next;
    })
  }
  submitUpdate() {
    const product = this.productForm.value;
    this.productService.updateProduct(product.id, product).subscribe(next => {
        this.dialogRef.close(true);
      }
    );
  }
}
