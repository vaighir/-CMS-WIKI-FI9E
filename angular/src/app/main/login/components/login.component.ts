import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit(loginForm: NgForm) {
    if(loginForm.valid) {
      console.log(loginForm.value);
      this.router.navigate(['article/all']);
    } else {
      alert("Bitte, füllen Sie alle Felder richtig aus");
    }

  }
}
