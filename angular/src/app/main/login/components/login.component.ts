import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/auth/user.model';
import { UserService } from 'src/app/nav-menu/services/user.service';
import {AuthService} from './../../../auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  constructor(
    private router: Router,
    private auth: AuthService,
    private userService: UserService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(loginForm: NgForm) {
    if(loginForm.valid) {

      this.auth.login(loginForm).then((res:any) => {
        this.auth.storeToken(res.data);
        
        const user: User = this.auth.getTokenPayload();
        
        this.userService.setUser(user);

        this.router.navigate(['article/all']);
      });


    } else {
      alert("Bitte, füllen Sie alle Felder richtig aus");
    }

  }
}
