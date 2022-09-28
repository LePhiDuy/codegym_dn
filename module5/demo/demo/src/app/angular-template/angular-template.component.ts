import {Component, Input, OnInit} from '@angular/core';
import {Student} from "../student";

@Component({
  selector: 'app-angular-template',
  templateUrl: './angular-template.component.html',
  styleUrls: ['./angular-template.component.css']
})
export class AngularTemplateComponent implements OnInit {
  @Input() appHighlight = '';
  color = "red";
  students:Student[] = [
    {name:"Lê Phi Duy", gender : 1, point:100},
    {name:"Nguyễn Phú Lĩnh", gender : 2, point:70},
    {name:"Chu Đức Anh", gender : 0, point:85},
    {name:"Nguyễn Hữu Chánh", gender : 1, point:90},
  ];
  constructor() { }

  ngOnInit(): void {
  }
  insert() {
    this.students.push({name:"Test", gender : 1, point:100});
  }
  trackById(index:number, item:any) {
    return index;
  }
}
