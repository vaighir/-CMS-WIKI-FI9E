import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { User } from 'src/app/auth/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userSource = new BehaviorSubject(new User());
  currentUser$ = this.userSource.asObservable();

  constructor(private authService: AuthService) {
    let data = this.authService.getTokenPayload();
    this.userSource.next(data);
   }

  setUser(user:User) {
    this.userSource.next(user);
  }
}
