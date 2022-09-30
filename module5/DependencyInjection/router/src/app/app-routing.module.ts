import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ArticleDetailComponent} from "./component/article-detail/article-detail.component";
import {ArticleComponent} from "./component/article-list/article.component";


const routes: Routes = [
  {
    path: '',
    redirectTo: 'article',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
