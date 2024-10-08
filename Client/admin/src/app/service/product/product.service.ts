import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl='http://localhost:8080/api/v1/products'

  constructor(private http:HttpClient) { }

  create(obj:any):Observable<any>{
    return this.http.post(this.baseUrl,{
      qty:obj.qty,
      unitPrice:obj.unitPrice,
      description:obj.description
    })
  }

}
