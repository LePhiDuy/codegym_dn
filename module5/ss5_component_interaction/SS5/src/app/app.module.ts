import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { P1NameCardComponent } from './p1-name-card/p1-name-card.component';
import { P2ProgressBarComponent } from './p2-progress-bar/p2-progress-bar.component';
import { E1RatingBarComponent } from './e1-rating-bar/e1-rating-bar.component';
import { MyComponentComponent } from './my-component/my-component.component';

@NgModule({
  declarations: [
    AppComponent,
    P1NameCardComponent,
    P2ProgressBarComponent,
    E1RatingBarComponent,
    MyComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
