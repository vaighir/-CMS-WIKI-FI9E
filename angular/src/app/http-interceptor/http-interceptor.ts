import { HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';
import { Injectable } from '@angular/core';


/**
 * Good source for other interceptor fun: https://indepth.dev/posts/1051/top-10-ways-to-use-interceptors-in-angular
 */
export class AddHeaderInterceptor implements HttpInterceptor {

  constructor() { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const headers = {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
    };

    const newRequest = req.clone({ setHeaders: headers });

    // Pass the cloned request instead of the original request to the next handle
    return next.handle(newRequest);
  }
}

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {
  constructor(private toastr: ToastrService) {
    //
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          
          if(error.status == 422) {
            console.log("custom error thrown ", error);

            return throwError(error.message);
          }
          
          let errorMsg = '';
          if (error.error instanceof ErrorEvent) {
            console.error('this is client side error');
            errorMsg = `Error: ${error.error.message}`;
          }
          else {
            console.error('this is server side error');
            errorMsg = `Error Code: ${error.status},  Message: ${error.message}`;
          }
          
          this.toastr.error(errorMsg);
          return throwError(errorMsg);
        })
      )
  }
  
}