import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { ListProductComponent } from './list-product/list-product.component';
import {ReactiveFormsModule} from '@angular/forms';
import { EditProductComponent } from './edit-product/edit-product.component';
import {HttpClientModule} from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {NgxPaginationModule} from 'ngx-pagination';
import {DatePipe} from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    CreateProductComponent,
    ListProductComponent,
    EditProductComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        ReactiveFormsModule,
        NgbModule,
        NgxPaginationModule
    ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
