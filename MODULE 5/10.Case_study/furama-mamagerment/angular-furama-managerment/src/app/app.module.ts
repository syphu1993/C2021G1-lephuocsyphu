import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from "@angular/material/dialog";
import {HttpClientModule} from "@angular/common/http";
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { HeaderComponent } from './layout/header/header.component';
import { BodyComponent } from './layout/body/body.component';
import { FooterComponent } from './layout/footer/footer.component';
import {NgxPaginationModule} from "ngx-pagination";
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CustomerUpdateComponent } from './customer/customer-update/customer-update.component';
import { CustomerDelComponent } from './customer/customer-del/customer-del.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    HeaderComponent,
    BodyComponent,
    FooterComponent,
    CustomerCreateComponent,
    CustomerUpdateComponent,
    CustomerDelComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatDialogModule,
        HttpClientModule,
        NgxPaginationModule,
        ReactiveFormsModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
