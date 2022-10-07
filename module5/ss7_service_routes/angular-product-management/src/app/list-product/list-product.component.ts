import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {CategoryService} from '../service/category.service';
import {ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {
  p = 1;
  products: Product[] = [];
  id: number;
  name: string;
  formSearch: FormGroup;

  constructor(private productService: ProductService, private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute, private formBuilder: FormBuilder,
              public datepipe: DatePipe) {
  }

  ngOnInit() {
    this.getAll();
    this.formSearch = this.formBuilder.group(
      {
        nameProduct: [],
        dateEnd: [],
        dateImportBegin: [],
        dateImportEnd: []
      }
    );
  }

  getAll() {
    this.productService.getAll().subscribe(
      data => {
        this.products = data;
      });
  }

  delete(id) {
    // tslint:disable-next-line:radix
    alert(id);
    this.productService.delete(id).subscribe(() => {
      alert('Delete successfully');
      this.getAll();
    }, error => {
      alert('Loi');
    });
  }

  changeId(id: number, name: string) {
    this.id = id;
    this.name = name;
  }

  search() {
    const nameProduct = this.formSearch.get('nameProduct').value || '';
    let dateEnd = this.formSearch.get('dateEnd').value;
    let dateImportBegin = this.formSearch.get('dateImportBegin').value;
    let dateImportEnd = this.formSearch.get('dateImportEnd').value;
    if (dateEnd === null) {
        dateEnd = this.datepipe.transform(new Date(), 'yyyy/MM/dd');
    }
    if (dateImportBegin === null) {
      dateImportBegin = this.datepipe.transform(new Date('1000-01-01'), 'yyyy/MM/dd');
    }
    if (dateImportEnd === null) {
      dateImportEnd = this.datepipe.transform(new Date(), 'yyyy/MM/dd');
    }
    this.productService.search(nameProduct, dateEnd, dateImportBegin, dateImportEnd)
      .subscribe(
        data => {
          this.products = data;
        }
      );
  }
}
