import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../dictionary-service.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-dictionary-mean',
  templateUrl: './dictionary-mean.component.html',
  styleUrls: ['./dictionary-mean.component.css']
})
export class DictionaryMeanComponent implements OnInit {
  mean: string;
  constructor(
    private dictionaryServiceService: DictionaryServiceService,
    private activatedRoute: ActivatedRoute,
    private domSanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get('word');
      this.mean = this.dictionaryServiceService.findMeanByWord(word);
    });
  }
}
