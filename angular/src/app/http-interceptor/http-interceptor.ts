import { HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';
import { Injectable } from '@angular/core';

const TOKEN_KEY = "fi9e_access_token";

/**
 * Good source for other interceptor fun: https://indepth.dev/posts/1051/top-10-ways-to-use-interceptors-in-angular
 */
export class AddHeaderInterceptor implements HttpInterceptor {
  
  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const CONTENT_TYPE = "Content-Type";
    const ACCEPT = "Accept";
    const AUTHORIZATION = "Authorization";

    let headers =  new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
    });

    const headerAcceptDefaul = 'application/json';
    const headerContentTypeDefault = 'application/json';

    //only set default headers, if none are present
    
    headers = headers.append(ACCEPT, req.headers.get(CONTENT_TYPE) || headerAcceptDefaul);
    headers = headers.append(CONTENT_TYPE, req.headers.get(ACCEPT) || headerContentTypeDefault);
    
    if(localStorage.getItem(TOKEN_KEY)) {
      headers = headers.append(AUTHORIZATION, "Bearer " + localStorage.getItem(TOKEN_KEY));
    }

    let newRequest = req.clone({ headers: headers });

    console.log(headers, newRequest);

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

            this.toastr.error(error.error.message.toString());

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

      //TODO: add success response interface
  }
  
}