import { Component, OnInit } from '@angular/core';
import {IWord} from "../model/i-word";
import {DictionaryServiceService} from "../dictionary-service.service";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  wordList: IWord[];
  constructor(private dictionaryService: DictionaryServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.wordList = this.dictionaryService.wordList;
  }
}
