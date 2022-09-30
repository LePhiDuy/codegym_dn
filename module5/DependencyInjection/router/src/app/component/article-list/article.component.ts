import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {Article} from "../../model/Article";
import {ArticleService} from "../../service/article.service";

@Component({
  selector: 'app-article-list',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  articles$: Observable<Article[]>;
  constructor(private _api: ArticleService) {}

  ngOnInit(): void {
    this.articles$ = this._api.getArticles();
  }
}
