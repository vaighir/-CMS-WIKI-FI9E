import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ArticlesComponent } from './articles/articles.component';
import { ArticlesAddComponent } from './articles-add/articles-add.component';


//our routes in our app
const routes: Routes = [
  { path: 'articles', component:  ArticlesComponent},
  { path: 'article/add', component: ArticlesAddComponent },
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes)]
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
    constructor() {
    }
 }
