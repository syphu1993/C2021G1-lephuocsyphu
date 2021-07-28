import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-del',
  templateUrl: './product-del.component.html',
  styleUrls: ['./product-del.component.css']
})
export class ProductDelComponent implements OnInit {

  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });
  constructor(
    private productService: ProductService,
    private activatedRoute: ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      console.log(this.productService.findById(parseInt(id)));
      this.productForm.patchValue(this.productService.findById(parseInt(id)));
    });
  }

  submit() {
    const product = this.productForm.value;
    this.productService.deleteProduct(product);
    this.router.navigate(['product/list'])
  }
}
