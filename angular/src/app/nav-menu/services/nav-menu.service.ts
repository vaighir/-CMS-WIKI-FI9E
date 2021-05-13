import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tag } from '../models/tag.model';
import { map } from 'rxjs/operators';
import { ApiRoutes } from 'src/app/routing-module/api-paths';


@Injectable({
  providedIn: 'root'
})
export class NavMenuService {

  constructor(
    private http: HttpClient
  ) { }

  tagList(): Observable<Tag[]> {
    return this.http.get<any[]>( ApiRoutes.uri.TAGLIST_SHOW + 'category/all' )
    .pipe(
      map((itmes) => itmes.map(
        (item) => Tag.createFromObj(item) 
      ))
    )
  }
}
