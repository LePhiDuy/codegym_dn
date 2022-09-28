import { Directive } from '@angular/core';
import {AbstractControl, ValidationErrors, ValidatorFn} from "@angular/forms";

export function forbiddenNameValidator(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const forbidden = nameRe.test(control.value);
    return forbidden ? null : {forbiddenName: {value: control.value}};
  };
}

@Directive({
  selector: '[appForbiddenName]'
})
export class ForbiddenNameDirective {

  constructor() { }

}
