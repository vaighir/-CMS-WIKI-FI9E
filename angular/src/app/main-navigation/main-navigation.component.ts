import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { User } from '../auth/user.model';
import { UserService } from '../nav-menu/services/user.service';

@Component({
  selector: 'app-main-navigation',
  templateUrl: './main-navigation.component.html',
  styleUrls: ['./main-navigation.component.scss']
})
export class MainNavigationComponent implements OnInit {
  currentUser?: User;

  constructor(private userService: UserService, private auth: AuthService) { }

  ngOnInit(): void {
    this.userService.currentUser$.subscribe(user => this.currentUser = user);
  }

  resetUser() : void {
    this.userService.setUser(new User());
    this.auth.storeToken("");
  }

  logout() : void {
    this.auth.logout()
    .then(() => {
      this.resetUser();
    });
  }
}
