import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../service/product.service';
import {Router, Routes} from '@angular/router';
import {CategoryService} from '../service/category.service';
import {Category} from '../model/category';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  formCreate: FormGroup;
  categories: Category[];

  // tslint:disable-next-line:variable-name
  constructor(private _formBuilder: FormBuilder, private _productService: ProductService,
              private router: Router, private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(
      value => {
        this.categories = value;
      }, error => {
        alert('Loi');
      }
    );
    this.formCreate = this._formBuilder.group({
      id: [],
      name: ['', [Validators.required]],
      price: ['', [Validators.required, Validators.min(150000)]],
      category: ['', [Validators.required]],
      description: ['', [Validators.required, Validators.minLength(10)]],
      dateImport: ['', [Validators.required]],
      dateProduce: ['', [Validators.required]],
      dateEnd: ['', [Validators.required]]
    },
      {
        validators: [this.dateValidator('dateProduce', 'dateImport'),
          this.dateValidator('dateProduce', 'dateEnd')]
      });
  }

  onSubmit() {
    const product = this.formCreate.value;
    this._productService.saveProduct(product).subscribe(
      data => {
        alert('Create successfully');
        this.router.navigateByUrl('/product/list');
      }
    );
  }
  dateValidator(dateStart: string, dateEnd: string) {
    return (formGroup: FormGroup) => {
      const control1 = formGroup.controls[dateStart];
      const control2 = formGroup.controls[dateEnd];

      if (control1.errors && !control2.errors.confirmedValidator) {
        return;
      }

      if (control1.value >  control2.value) {
        control2.setErrors({ dateValidator: true });
      } else {
        control2.setErrors(null);
      }
    };
  }
  get name() {
    return this.formCreate.get('name');
  }
  get price() {
    return this.formCreate.get('price');
  }
  get category() {
    return this.formCreate.get('category');
  }
  get description() {
    return this.formCreate.get('description');
  }
  get dateImport() {
    return this.formCreate.get('dateImport');
  }
  get dateProduce() {
    return this.formCreate.get('dateProduce');
  }
  get dateEnd() {
    return this.formCreate.get('dateEnd');
  }
}
