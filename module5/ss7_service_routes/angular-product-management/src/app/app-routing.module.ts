import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListProductComponent} from './list-product/list-product.component';
import {CreateProductComponent} from './create-product/create-product.component';
import {EditProductComponent} from './edit-product/edit-product.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'product/list',
    pathMatch: 'full',
  },
  {
    path: 'product',
    children: [
      {path: 'list', component: ListProductComponent},
      {path: 'create', component: CreateProductComponent},
      {path: 'edit/:id', component: EditProductComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
