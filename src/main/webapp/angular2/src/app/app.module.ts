import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { UpdateUserComponent } from './updateuser.component';
import { UserComponent } from './user.component';
import {routing} from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    UpdateUserComponent,
    UserComponent
  ],
  imports: [
      BrowserModule,
      FormsModule,
      HttpModule,
      ReactiveFormsModule,
      routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
