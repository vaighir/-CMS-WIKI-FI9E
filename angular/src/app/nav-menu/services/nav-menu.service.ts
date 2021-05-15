import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ApiRoutes } from 'src/app/routing-module/api-paths';
import { Category } from '../models/category.model';


@Injectable({
  providedIn: 'root'
})
export class NavMenuService {

  constructor(
    private http: HttpClient
  ) { }

  categoryList(): Observable<Category[]> {
    return this.http.get<any[]>( ApiRoutes.uri.CATEGORYLIST_SHOW + 'category/all' )
    .pipe(
      map((itmes) => itmes.map(
        (item) => Category.createFromObj(item) 
      ))
    )
  }
}
