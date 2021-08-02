import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BodyComponent} from "./layout/body/body.component";
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {CustomerCreateComponent} from "./customer/customer-create/customer-create.component";


const routes: Routes = [{
  path: '',
  component: BodyComponent
},{
  path: 'customer/list',
  component: CustomerListComponent
},{
  path: 'customer/create',
  component: CustomerCreateComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
