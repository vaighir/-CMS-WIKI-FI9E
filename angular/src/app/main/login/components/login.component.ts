import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/auth/user.model';
import { UserService } from 'src/app/nav-menu/services/user.service';
import { AuthService } from './../../../auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private router: Router,
    private auth: AuthService,
    private userService: UserService,
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

  login() {
    if (this.loginForm.valid) {

      this.auth.login(this.loginForm).then((res: any) => {
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
