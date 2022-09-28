import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {forbiddenNameValidator} from "../forbidden-name.directive";

@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.css']
})
export class ProfileEditorComponent implements OnInit {
  profileForm: FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    // this.profileForm = new FormGroup( {
    //   firstName : new FormControl('', Validators.required),
    //   lastName: new FormControl(''),
    //   address: new FormGroup({
    //     street: new FormControl(''),
    //     city: new FormControl(''),
    //     state: new FormControl(''),
    //     zip: new FormControl('')
    //   })
    // });
    this.profileForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.minLength(4), forbiddenNameValidator(/bob/i)]],
      lastName: [''],
      address: this.formBuilder.group({
        street: [''],
        city: [''],
        state: [''],
        zip: ['']
      }),
      aliases: this.formBuilder.array([
        this.formBuilder.control('')
      ])
    });

  }
  get aliases() {
    return this.profileForm.get('aliases') as FormArray;
  }
  addAlias() {
    this.aliases.push(this.formBuilder.control(''));
  }
  onSubmit() {
    console.warn(this.profileForm.value);
  }
  updateProfile() {
    this.profileForm.setValue({
      firstName: 'Phi Duy',
      lastName: 'Le',
      address: {
        street: 'Bau Mac 20',
        city: 'Da Nag',
        state: 'Trang thai',
        zip: '43'
      }
    });
  }
  get firstName() {
    return this.profileForm.get('firstName');
  }
}
