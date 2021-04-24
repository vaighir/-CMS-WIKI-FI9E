import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IApiResource } from './interfaces/IApiResource';
import { ApiRoutes } from './routing-module/api-paths';

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

}
