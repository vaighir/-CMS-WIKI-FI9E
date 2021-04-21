import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { NavMenuComponent } from './nav-menu/nav-menu.component';
import { MainComponent } from './main/main.component';
import { MainNavigationComponent } from './main-navigation/main-navigation.component';
import { ArticlesComponent } from './articles/articles.component';
import { AppRoutingModule } from './app-routing.module';
import { ArticlesAddComponent } from './articles-add/articles-add.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    NavMenuComponent,
    MainComponent,
    MainNavigationComponent,
    ArticlesComponent,
    ArticlesAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
