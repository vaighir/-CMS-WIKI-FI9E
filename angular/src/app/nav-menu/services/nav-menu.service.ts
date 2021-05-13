import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tag } from '../models/tag.model';
import { map } from 'rxjs/operators';
import { API_ROUTES } from 'src/app/app-routing.module';


@Injectable({
  providedIn: 'root'
})
export class NavMenuService {

  constructor(
    private http: HttpClient
  ) { }

  tagList(): Observable<Tag[]> {
    return this.http.get<any[]>( API_ROUTES.TAGLIST_SHOW + 'user/2' )
    .pipe(
      map((itmes) => itmes.map(
        (item) => Tag.createFromObj(item) 
      ))
    )
  }
}
