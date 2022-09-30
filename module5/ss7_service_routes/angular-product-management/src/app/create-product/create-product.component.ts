import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../service/product.service';
import {Router, Routes} from '@angular/router';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  formCreate: FormGroup;
  // tslint:disable-next-line:variable-name
  constructor(private _formBuilder: FormBuilder, private _productService: ProductService, private _router: Router) { }

  ngOnInit(): void {
    this.formCreate = this._formBuilder.group({
      id: [''],
      name: [''],
      price: [''],
      description: ['']
    });
  }
  onSubmit() {
    const product = this.formCreate.value;
    this._productService.saveProduct(product);
    this._router.navigateByUrl('/product/list');
  }
}
