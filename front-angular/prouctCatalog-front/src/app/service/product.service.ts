import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Product } from 'src/models/Product';

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    constructor(private httpClient: HttpClient) { }

    post(product: Product): Observable<Product> {
        return this.httpClient.post<Product>(`${environment.backend}products`, product);
    }

    put(product: Product, id: string): Observable<Product> {
        return this.httpClient.put<Product>(`${environment.backend}products/${id}`, product);
    }

    getById(id: string): Observable<Product> {
        return this.httpClient.get<Product>(`${environment.backend}products/${id}`);
    }

    get(): Observable<Product[]> {
        return this.httpClient.get<Product[]>(`${environment.backend}products`);
    }

    getFiltered(min_price: number, max_price: number, description: string): Observable<Product[]> {
        const params = new HttpParams();
        if (min_price) {
            params.append('min_price', min_price.toString());
        }
        if (max_price) {
            params.append('max_price', max_price.toString());
        }
        if (description) {
            params.append('q', description);
        }

        return this.httpClient.get<Product[]>(`${environment.backend}products/`, { params });

    }

    delete(id: string): Observable<any> {
        return this.httpClient.delete<any>(`${environment.backend}products/${id}`);
    }



}
