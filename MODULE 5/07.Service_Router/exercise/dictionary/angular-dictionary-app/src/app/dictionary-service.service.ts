import { Injectable } from '@angular/core';
import {IWord} from "./model/i-word";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  wordList: IWord[] = [
     {word: "hello",
      mean: "xin chao"},
     {word: "guava",
      mean: "qua oi"},
     {word: "fruit",
      mean: "trai cay"},
     {word: "ogrance",
      mean: "qua cam"}
  ];
  constructor() { }

  findMeanByWord(word: string) {
    for (let w of this.wordList){
      if (word==w.word){
        return w.mean;
      }
    }
  }
}
