import { Component, OnInit } from '@angular/core';
import { User } from '../auth/user.model';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  user: User = new User();

  constructor() { }

  ngOnInit(): void {

  }

  setUser(user:User) {
    this.user = user;
  }
}
