import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, Router, RouterModule } from '@angular/router';
import { ArticlesComponent } from './main/articles/components/articles/articles.component';
import { ArticlesAddComponent } from './main/articles/components/articles-add/articles-add.component';
import { LoginComponent } from './main/login/login.component';
import { ArticleDetailComponent } from './main/articles/components/article-detail/article-detail.component';

//our routes in our app
const routes: Routes = [
  { path: 'articles', component: ArticlesComponent },
  { path: 'article/add', component: ArticlesAddComponent },
  { path: 'article/datail', component: ArticleDetailComponent },
  { path: 'login', component: LoginComponent },
];
//http://localhost:8080/RestAPI/v1/article/add

//@TODO:
//Add headers to every request
//Content-Type: application/json
//Accept: application/json

const host: string = "http://localhost:8080";
const API_V1: string = "/RestAPI/v1/";
export const API_ROUTES = {
  ARTICLE_ADD: host+API_V1+ "article/add"
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
      this.router.navigate(['/articles']);
    }

 }
