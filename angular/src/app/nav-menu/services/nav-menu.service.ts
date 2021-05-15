import { HttpClient } from '@angular/common/http';
import { Injectable, EventEmitter } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ApiRoutes } from 'src/app/routing-module/api-paths';
import { Category } from '../models/category.model';


@Injectable({
  providedIn: 'root'
})
export class NavMenuService {
  // categoryIdUpdated = new EventEmitter<number>();
  private CategoryIdSource = new BehaviorSubject(-1);
  currentCategoryId = this.CategoryIdSource.asObservable();

  constructor(
    private http: HttpClient
  ) { }

  updateCategoryId(id: number) {
    this.CategoryIdSource.next(id)
  }

  categoryList(): Observable<Category[]> {
    return this.http.get<any[]>( ApiRoutes.uri.CATEGORYLIST_SHOW + 'category/all' )
    .pipe(
      map((itmes) => itmes.map(
        (item) => Category.createFromObj(item) 
      ))
    )
  }
}
