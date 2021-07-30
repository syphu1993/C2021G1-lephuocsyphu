import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../model/product";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public api_url = "http://localhost:3000/products";
  constructor(private htpt: HttpClient) { }

  findAllProduct(): Observable<any>{
    return this.htpt.get(this.api_url);
  }
  createProduct(value: any): Observable<any>{
    return this.htpt.post(this.api_url,value);
  }
  deleteProduct(id: number): Observable<Product> {
    return this.htpt.delete<Product>(`${this.api_url}/${id}`);
  }
}
