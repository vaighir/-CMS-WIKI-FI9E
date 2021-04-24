import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';


export class AddHeaderInterceptor  implements HttpInterceptor {

  constructor() { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      // Clone the request to add the new header
      let rq = req.clone({headers: req.headers.append('Accept', 'application/json')});
      const rq2 = rq.clone({headers: rq.headers.append('Content-Type', 'application/json')});
      
      // Pass the cloned request instead of the original request to the next handle
      return next.handle(rq2);
    }
  }

