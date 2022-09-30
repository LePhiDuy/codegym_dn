import {Injectable} from '@angular/core';
import {Product} from "../model/Product";
import {LoggerService} from "./logger.service";

@Injectable()
export class ProductService {
  constructor(private loggerService:LoggerService) {
    this.loggerService.log("Logger service start()");
  }
  getAll() {
    let products: Product[];
    products = [
      new Product(1, "Iphone", 100000),
      new Product(2, "Samsung", 152366),
      new Product(3, "TV", 14578),
    ]
    this.loggerService.log("Hello");
    return products;
  }
}
