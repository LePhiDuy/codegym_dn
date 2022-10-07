import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

const apiUrl = environment.api_url;

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http: HttpClient) { }
  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(apiUrl + '/products');
  }
  // @ts-ignore
  saveProduct(product): Observable<Product> {
    return this.http.post<Product>(apiUrl + '/products', product);
  }
  findById(id: number): Observable<Product> {
    return this.http.get<Product>( `${apiUrl}/products/${id}`);
  }
  // @ts-ignore
  delete(id: number): Observable<Product> {
    return this.http.delete<Product>(`${apiUrl}/products/${id}`);
  }
  // @ts-ignore
  update(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${apiUrl}/products/${id}`, product);
  }
  search(name: string, dateEnd: Date, dateImportBegin: Date, dateImportEnd: Date): Observable<Product[]> {
    return this.http.get<Product[]>
    (`${apiUrl}/products?name_like=${name}&dateEnd_lte=${dateEnd}
    &dateImport_gte=${dateImportBegin}&dateImport_lte=${dateImportEnd}`);
  }
}
