import { Component, OnInit } from '@angular/core';
import {WordService} from "../service/WordService";
import {ActivatedRoute} from "@angular/router";
import {Word} from "../model/Word";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word: Word;
  constructor(private wordService: WordService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.word = this.wordService.findById(id);
  }

}
