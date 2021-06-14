import { ArticleEditComponent } from './main/articles/components/article-edit/article-edit.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, Router, RouterModule } from '@angular/router';
import { ArticlesComponent } from './main/articles/components/articles/articles.component';
import { ArticlesAddComponent } from './main/articles/components/articles-add/articles-add.component';
import { LoginComponent } from './main/login/components/login.component';
import { ArticleDetailComponent } from './main/articles/components/article-detail/article-detail.component';
import { NoPageComponent } from './main/no-page/no-page.component';
import { RegisterComponent } from './main/register/register.component';
import { AuthGuard } from './auth/auth.guard';
import { WarningComponent } from './main/warning/warning.component';

//our routes in our app
const routes: Routes = [
  { path: '', redirectTo: 'article/all', pathMatch: 'full' },
  { path: 'article/all', component: ArticlesComponent },
  { path: 'article/category/:id', component: ArticlesComponent },
  { path: 'article/add', component: ArticlesAddComponent, canActivate: [AuthGuard]},
  { path: 'article/:id', component: ArticleDetailComponent },
  { path: 'article/edit/:id', component: ArticleEditComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'warning', component: WarningComponent },
  {path:'**', component: NoPageComponent }

];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes, {useHash: true})]
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
