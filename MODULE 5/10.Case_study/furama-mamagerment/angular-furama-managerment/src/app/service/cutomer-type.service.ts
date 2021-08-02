import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  public api_url = "http://localhost:3000/type";
  constructor(private http: HttpClient) { }
  findAll(): Observable<any>{
    return this.http.get(this.api_url);
  }
}
