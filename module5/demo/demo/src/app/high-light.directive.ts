import {Directive, ElementRef} from '@angular/core';

@Directive({
  selector: '[appHighLight]'
})
export class HighLightDirective {

  constructor(private e: ElementRef) {
    this.e.nativeElement.style.backgroundColor = "yellow";
  }

}
