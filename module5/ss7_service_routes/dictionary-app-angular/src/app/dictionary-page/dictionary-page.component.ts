import { Component, OnInit } from '@angular/core';
import {WordService} from "../service/WordService";
import {Word} from "../model/Word";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  words: Word[];
  constructor(private wordService: WordService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.words = this.wordService.getAll();
  }
}
