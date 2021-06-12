import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { IApiResource } from '../interfaces/IApiResource';
import { ApiRoutes, HeadersForms } from '../routing-module/api-paths';
import { JwtHelperService } from "@auth0/angular-jwt";
import { User } from './user.model';

export const TOKEN_KEY = "fi9e_access_token";

@Injectable({
  providedIn: 'root'
})
export class AuthService implements IApiResource {
  constructor(private http: HttpClient) { }

  /**
   * Login user and store acces key in local storage for further requests
   * @param form 
   * @returns Promise
   */
  login(form: NgForm) {
    const payload: HttpParams = new HttpParams()
      .set("username", form.value.email)
      .set("password", form.value.password);

    return this.http.post<any>(ApiRoutes.uri.LOGIN, payload, { headers: new HttpHeaders().set('Accept', 'application/x-www-form-urlencoded') }).toPromise();
  }

  /**
   * 
   * @returns Logout user from API
   */
  logout() {
    return this.http.post<any>(ApiRoutes.uri.LOGOUT, this.getToken()).toPromise();
  }

  storeToken(token: string) {
    localStorage.setItem(TOKEN_KEY, token);
  }

  getToken() {
    return localStorage.getItem(TOKEN_KEY);
  }

  show(id: number): Observable<any> {
    throw new Error('Method not implemented.');
  }

  store(model: any) {
    throw new Error('Method not implemented.');
  }

  delete(id: number) {
    throw new Error('Method not implemented.');
  }

  update(model: any) {
    throw new Error('Method not implemented.');
  }

  getTokenPayload() {
    const token = this.getToken() || "";

    if(token === "") {
      return new User();
    }

    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(token);

    if(!decodedToken) {
      return new User();
    }

    //const expirationDate = helper.getTokenExpirationDate(token);
    const isExpired = helper.isTokenExpired(token);

    let user: User = new User();
    user.id = decodedToken.user_id;
    user.email = decodedToken.email;
    user.username = decodedToken.username;
    user.isExpiredToken = isExpired;

    return user;
  }

}
