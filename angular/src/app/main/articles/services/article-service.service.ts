import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IApiResource } from 'src/app/interfaces/IApiResource';
import { ApiRoutes } from 'src/app/routing-module/api-paths';
import { API_ROUTES } from '../../../app-routing.module';
import { ArticleModel } from '../model/article-model.Model';

@Injectable({
  providedIn: 'root'
})
export class ArticleServiceService implements IApiResource {

  constructor(private http: HttpClient) {

  }
  show() {
    throw new Error('Method not implemented.');
  }
  store(model: any) {
    this.http.post( ApiRoutes.uri.ARTICLE_ADD, model).toPromise().then((res) => {
      console.log(res);
    }).catch((err) => {
      console.log(err);
    });
  }
  delete() {
    throw new Error('Method not implemented.');
  }
  update() {
    throw new Error('Method not implemented.');
  }

   addArticle(article: ArticleModel) : void  {
     this.http.post( API_ROUTES.ARTICLE_ADD , article).toPromise().then((res) => {
       console.log(res);
       
     }).catch((err) => {
       console.error(err);
     });
   }
}
