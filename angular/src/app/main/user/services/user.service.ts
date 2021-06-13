import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiRoutes } from 'src/app/routing-module/api-paths';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
   }

   userList(): Observable<any>{
     return this.http.get( ApiRoutes.uri.USERLIST_SHOW);
   }
   
   add(user: User): Observable<User> {
     return this.http.post<User>( ApiRoutes.uri.REGISTER, user);
   }
}
