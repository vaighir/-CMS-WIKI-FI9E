import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_ROUTES } from '../../../app-routing.module';
import { ArticleModelModule } from '../article-model/article-model.module';

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
    this.http.post( ApiRoutes.uri.ARTICLE_ADD, model).toPromise().then((response) => {
      console.log();
    }).catch((error) => {
      //handle error
    });
  }
  delete() {
    throw new Error('Method not implemented.');
  }
  update() {
    throw new Error('Method not implemented.');
  }

   addArticle(article: ArticleModelModule) : void  {
     this.http.post( API_ROUTES.ARTICLE_ADD , article).toPromise().then((res) => {
       console.log(res);
       
     }).catch((err) => {
       console.error(err);
     });
   }
}
