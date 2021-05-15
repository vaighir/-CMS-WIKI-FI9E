import { ArticleEditComponent } from './main/articles/components/article-edit/article-edit.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, Router, RouterModule } from '@angular/router';
import { ArticlesComponent } from './main/articles/components/articles/articles.component';
import { ArticlesAddComponent } from './main/articles/components/articles-add/articles-add.component';
import { LoginComponent } from './main/login/components/login.component';
import { ArticleDetailComponent } from './main/articles/components/article-detail/article-detail.component';

//our routes in our app
const routes: Routes = [
  { path: 'articles', component: ArticlesComponent },
  { path: 'article/category/:id', component: ArticlesComponent },
  { path: 'article/add', component: ArticlesAddComponent },
  { path: 'article/:id', component: ArticleDetailComponent },
  { path: 'article/edit/:id', component: ArticleEditComponent },
  { path: 'login', component: LoginComponent },
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
    constructor(private router: Router) {

      //@TODO: dont route always to articles, only if history empty (no pages visited yet)
      this.router.navigate(['/articles']);
    }

 }
