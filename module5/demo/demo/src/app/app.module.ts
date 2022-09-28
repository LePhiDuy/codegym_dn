import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AngularTemplateComponent } from './angular-template/angular-template.component';
import { HighLightDirective } from './high-light.directive';
import { AngularPipesComponent } from './angular-pipes/angular-pipes.component';
import { AngularFormComponent } from './angular-form/angular-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import { NameEditorComponent } from './angular-io-form/name-editor/name-editor.component';
import { ProfileEditorComponent } from './angular-io-form/profile-editor/profile-editor.component';
import { ForbiddenNameDirective } from './angular-io-form/forbidden-name.directive';

@NgModule({
  declarations: [
    AppComponent,
    AngularTemplateComponent,
    HighLightDirective,
    AngularPipesComponent,
    AngularFormComponent,
    NameEditorComponent,
    ProfileEditorComponent,
    ForbiddenNameDirective,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
