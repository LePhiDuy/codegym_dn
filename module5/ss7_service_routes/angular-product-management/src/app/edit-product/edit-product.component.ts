import {Component, OnInit} from '@angular/core';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CategoryService} from '../service/category.service';
import {Category} from '../model/category';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  formEdit: FormGroup;
  id: number;
  categories: Category[];

  // tslint:disable-next-line:variable-name
  constructor(private _productService: ProductService, private activatedRoute: ActivatedRoute,
              private fb: FormBuilder, private router: Router, private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    // tslint:disable-next-line:radix
    this.categoryService.getAll().subscribe(
      value => {
        this.categories = value;
      }, error => {
        alert('Loi');
      }
    );
    this.formEdit = this.fb.group({
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
    // tslint:disable-next-line:radix
    this.id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this._productService.findById(this.id).subscribe(product => {
      this.formEdit.patchValue(product);
      console.log(product);
    });
  }

  onSubmit(id: number) {
    const product = this.formEdit.value;
    this._productService.update(id, product).subscribe(() => {
      alert('Update Successfully');
      this.router.navigateByUrl('product/list');
    }, error => {
      alert('Loi');
    });
  }
  compareObjects(o1: any, o2: any) {
    if (o1 === null || o2 === null) {
      return false;
    }
    return o1.id === o2.id;
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
    return this.formEdit.get('name');
  }
  get price() {
    return this.formEdit.get('price');
  }
  get category() {
    return this.formEdit.get('category');
  }
  get description() {
    return this.formEdit.get('description');
  }
  get dateImport() {
    return this.formEdit.get('dateImport');
  }
  get dateProduce() {
    return this.formEdit.get('dateProduce');
  }
  get dateEnd() {
    return this.formEdit.get('dateEnd');
  }
}
