import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });
  public category: Category[];
  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router ) { }

  ngOnInit(): void {
    this.getFindAllCategory();
  }
  getFindAllCategory(){
    this.categoryService.findAllCategory().subscribe(next=>{
      this.category = next;
    })
  }
  submit() {
    console.log(this.productForm.value);
    if (this.productForm.valid){
      this.productService.createProduct(this.productForm.value).subscribe(next => {
        this.router.navigate(["/product/list"])
        }
      )
    }else {
      alert("Form error!")
    }
  }
}
