import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  constructor(
    private router: Router,
    private fb: FormBuilder
  ) {
    let loginControls = {
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required])
    }
    this.loginForm = this.fb.group(loginControls);
    
   }
   get email() { return this.loginForm.get('email') }
   get password() { return this.loginForm.get('password') }
  ngOnInit(): void {
  }

  login(loginForm: NgForm) {
// TODO: test user login
console.log(loginForm);
  }
}
