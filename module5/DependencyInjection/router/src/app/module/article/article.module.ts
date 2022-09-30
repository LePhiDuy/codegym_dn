import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ArticleComponent} from "../../component/article-list/article.component";
import {ArticleDetailComponent} from "../../component/article-detail/article-detail.component";
import {RouterModule, Routes} from "@angular/router";
import {ArticleRoutingModule} from "./article-routing.module";
import {ArticleLayoutComponent} from "../../component/articleLayout.component";

const routes: Routes = [
  {
    path: 'article',
    component: ArticleComponent,
  },
  {
    path: 'article/:slug',
    component: ArticleDetailComponent,
  },
];

@NgModule({
  imports: [CommonModule, ArticleRoutingModule],
  declarations: [ArticleComponent, ArticleDetailComponent, ArticleLayoutComponent]
})
export class ArticleModule {
}
