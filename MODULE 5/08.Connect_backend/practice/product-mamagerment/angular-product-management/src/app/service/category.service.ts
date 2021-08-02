import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  public api_url = "http://localhost:3000/category";
  constructor(private http: HttpClient) { }
  findAllCategory(): Observable<any>{
    return this.http.get(this.api_url);
  }
}
