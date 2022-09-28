import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators} from "@angular/forms";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  signUpForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.signUpForm = this.formBuilder.group({
      email: ['', [Validators.email, Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required, Validators.minLength(6)]],
      country: ['', [Validators.required]],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]]
    }, {validators: this.passwordConfirm('password', 'confirmPassword')});
  }

  get email() {
    return this.signUpForm.get('email');
  }

  get password() {
    return this.signUpForm.get('password');
  }

  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }

  get country() {
    return this.signUpForm.get('country');
  }

  get age() {
    return this.signUpForm.get('age');
  }

  get gender() {
    return this.signUpForm.get('gender');
  }

  get phone() {
    return this.signUpForm.get('phone');
  }

  const
  passwordConfirm = (password: string, confirmPassword: string) => {
    return function (formGroup: FormGroup): ValidationErrors | null {
      const {value: password} = formGroup.get('password') as AbstractControl;
      const {value: confirmPassword} = formGroup.get('confirmPassword') as AbstractControl;
      return password === confirmPassword
        ? null
        : {
          valueNotMatch: {
            password,
            confirmPassword,
          },
        };
    };
  }
}
