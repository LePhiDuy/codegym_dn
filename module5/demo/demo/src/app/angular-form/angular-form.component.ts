import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-angular-form',
  templateUrl: './angular-form.component.html',
  styleUrls: ['./angular-form.component.css']
})
export class AngularFormComponent implements OnInit {

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    // this.rfStudent = new FormGroup(
    //   {
    //     studentName: new FormControl('Duy'),
    //     studentGender: new FormControl(),
    //     studentPoint: new FormControl()
    //   }
    // );
    this.rfStudent = this._formBuilder.group({
      studentName: ['Duy', [Validators.required]],
      studentGender: [],
      studentPoint: []
    })
  }
  rfStudent: FormGroup;
  submit() {
    console.log(this.rfStudent.value);
  }
}
