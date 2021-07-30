import {Component, Inject, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Route, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

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
  });
  constructor(
    public dialogRef: MatDialogRef<ProductUpdateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
  //   this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
  //     const id = paramMap.get('id');
  //     console.log(this.productService.findById(parseInt(id)));
  //     this.productForm.patchValue(this.productService.findById(parseInt(id)));
  // });
    this.productForm.patchValue(this.productService.findById(parseInt(this.data.id)));
}

  submit() {
    const product = this.productForm.value;
    this.productService.updateProduct(product);
    this.router.navigate([this.dialogRef.close()])
  }
}
