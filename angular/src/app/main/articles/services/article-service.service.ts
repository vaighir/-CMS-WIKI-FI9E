import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IApiResource } from 'src/app/interfaces/IApiResource';
import { ApiRoutes } from 'src/app/routing-module/api-paths';

@Injectable({
  providedIn: 'root',
})
export class ArticleService implements IApiResource {

  constructor(private http: HttpClient) {

  }
  articleList(): Observable<any> {
    return this.http.get( ApiRoutes.uri.ARTICLELIST_SHOW );
  }

  articleListByCategory(id: number): Observable<any> {
    return this.http.get( ApiRoutes.uri.ARTICLELISTBYCATEGORY_SHOW + id);
  }

  show(id: number) : Observable<any> {
    return this.http.get( ApiRoutes.uri.ARTICLE_SHOW + id );
  }
   store(model: any) {
    return this.http.post( ApiRoutes.uri.ARTICLE_ADD, model);
  }
  delete(id: number) {
    return this.http.delete<number>( ApiRoutes.uri.ARTICLE_DELETE + id);
  }
  update(model: any) {
    return this.http.put( ApiRoutes.uri.ARTICLE_UPDATE + model.id, model );
  }
}