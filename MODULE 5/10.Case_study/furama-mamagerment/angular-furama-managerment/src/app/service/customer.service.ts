import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../module/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public api_url = "http://localhost:3000/customer";
  constructor(private http: HttpClient) { }
  findAll(): Observable<any>{
    return this.http.get(this.api_url);
  }
  createCustomer(value: any): Observable<any>{
    return this.http.post(this.api_url,value);
  }
  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.api_url}/${id}`, customer);
  }
  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.api_url}/${id}`);
  }
  search(searchText: string, searchText1: string, searchText2: string): Observable<any> {
    return this.http.get(this.api_url + '?name_like=' + searchText + '&address_like=' + searchText1 + '&type.name_like=' + searchText2);
  }
}
