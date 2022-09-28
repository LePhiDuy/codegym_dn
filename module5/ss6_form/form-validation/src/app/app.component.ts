import { Component } from '@angular/core';

export type FormType = 'sign-in' | 'sign-up';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'form-validation';
  form: FormType = 'sign-in';

  get showFormSignIn() {
    return this.form === 'sign-in';
  }

  get showFormSignUp() {
    return this.form === 'sign-up';
  }

  toggleEditor(type: FormType) {
    this.form = type;
  }
}
