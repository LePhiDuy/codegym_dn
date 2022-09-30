import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.css']
})
export class DeleteProductComponent implements OnInit {

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    // tslint:disable-next-line:radix
    const id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.productService.delete(id);
    this.router.navigateByUrl('/product/list');
  }

}
