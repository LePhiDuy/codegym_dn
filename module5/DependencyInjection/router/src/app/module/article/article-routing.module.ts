import {RouterModule, Routes} from "@angular/router";
import {ArticleComponent} from "../../component/article-list/article.component";
import {ArticleDetailComponent} from "../../component/article-detail/article-detail.component";
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ArticleLayoutComponent} from "../../component/articleLayout.component";

const routes: Routes = [{
  path: 'article',
  component: ArticleLayoutComponent,
  children: [
    {
      path: '',
      component: ArticleComponent,
    },
    {
      path: ':slug',
      component: ArticleDetailComponent,
    }]
}
];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(routes)],
  declarations: [],
  exports: [RouterModule]
})
export class ArticleRoutingModule {
}
