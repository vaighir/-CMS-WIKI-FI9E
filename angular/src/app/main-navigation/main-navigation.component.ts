import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { User } from '../auth/user.model';
import { UserService } from '../nav-menu/services/user.service';

@Component({
  selector: 'app-main-navigation',
  templateUrl: './main-navigation.component.html',
  styleUrls: ['./main-navigation.component.scss']
})
export class MainNavigationComponent implements OnInit {
  currentUser: User = new User();

  constructor(private userService: UserService, private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.userService.currentUser$.subscribe(user => this.currentUser = user);
    this.userService.setUser( this.auth.getTokenPayload() );
  }

  resetUser() : void {
    this.userService.setUser(new User());
    this.auth.storeToken("");
  }

  logout() : void {
    this.auth.logout()
    .then(() => {
      this.resetUser();
      this.router.navigate(['login']);
    });
  }
}
