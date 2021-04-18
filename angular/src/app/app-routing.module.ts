import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, Router, RouterModule } from '@angular/router';
import { ArticlesComponent } from './articles/articles.component';
import { ArticlesAddComponent } from './articles-add/articles-add.component';

//our routes in our app
const routes: Routes = [
  { path: 'articles', component: ArticlesComponent },
  { path: 'article/add', component: ArticlesAddComponent },
];
const host: string = "http://localhost";
const API_V1: string = "/v1/";
export const API_ROUTES = {
  ARTICLE_ADD: host+API_V1+ "/article/add"
}

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes)]
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
    constructor(private router: Router) {

      //@TODO: dont route always to articles, only if history empty (no pages visited yet)
      this.router.navigate(['article/add']);
    }
 }
