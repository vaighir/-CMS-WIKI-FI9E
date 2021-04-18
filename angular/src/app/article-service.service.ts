import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_ROUTES } from './app-routing.module';
import { ArticleModelModule } from "./article-model/article-model.module";

@Injectable({
  providedIn: 'root'
})
export class ArticleServiceService {

  constructor(private http: HttpClient) {

  }

   addArticle(article: ArticleModelModule) : void  {
     this.http.post( API_ROUTES.ARTICLE_ADD , article).toPromise().then((response) => {
       //handle
     }).catch((error) => {
       //handle error
     });
   }
}
