import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  formEdit: FormGroup;

  // tslint:disable-next-line:variable-name
  constructor(private _productService: ProductService, private activatedRoute: ActivatedRoute,
              private fb: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    // tslint:disable-next-line:radix
    const idEdit = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    const product = this._productService.findById(idEdit);
    this.formEdit = this.fb.group({
      id: [product.id],
      name: [product.name],
      price: [product.price],
      description: [product.description]
    });
  }
  onSubmit() {
    const product = this.formEdit.value;
    this._productService.saveProduct(product);
    this.router.navigateByUrl('/product/list');
  }
}
