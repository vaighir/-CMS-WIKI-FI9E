import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {AuthService} from './../../../auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    private router: Router,
    private auth: AuthService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(loginForm: NgForm) {
    if(loginForm.valid) {

      this.auth.login(loginForm);

      console.log(loginForm.value);

      

      //this.router.navigate(['article/all']);
    } else {
      alert("Bitte, füllen Sie alle Felder richtig aus");
    }

  }
}
