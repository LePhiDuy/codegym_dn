import { Component } from '@angular/core';
import {Product} from "./model/Product";
import {ProductService} from "./service/product.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'dependencyInjection';
  products: Product[];
  constructor(private productService:ProductService) {
  }
  getAllProducts() {
    this.products =  this.productService.getAll();
  }
}
