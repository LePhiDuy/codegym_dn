import { Component } from "@angular/core";

@Component({
  selector: 'app-article-layout',
  template: `
<h3>Article Parent</h3>
<router-outlet></router-outlet>
  `
})
export class ArticleLayoutComponent {}
