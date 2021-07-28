import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryPageComponent} from "./dictionary-page/dictionary-page.component";
import {DictionaryMeanComponent} from "./dictionary-mean/dictionary-mean.component";


const routes: Routes = [
  {
    path: '',
    component: DictionaryPageComponent,
  },
  {
    path: ':word',
    component: DictionaryMeanComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
