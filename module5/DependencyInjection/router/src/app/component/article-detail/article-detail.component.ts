import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Article} from "../../model/Article";
import {ArticleService} from "../../service/article.service";
import {map, switchMap} from "rxjs/operators";

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {

  article$: Observable<Article>;
  constructor(private _route: ActivatedRoute, private _api: ArticleService) {}

  ngOnInit(): void {
    // let slug = this._route.snapshot.paramMap.get('slug');
    // this.article$ = this._api.getArticleBySlug(slug);
    this.article$ = this._route.paramMap.pipe(
      map((params) => params.get('slug')),
      switchMap((slug) => this._api.getArticleBySlug(slug))
    );
  }
}
