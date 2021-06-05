import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from '../user/model/user.model';
import { UserService } from '../user/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private toastr: ToastrService,
    private userService: UserService

  ) { 
    let formControls = {
      firstname: new FormControl('',[
        Validators.required,
        Validators.pattern("[A-Za-z .'-]+"),
        Validators.minLength(2)
      ]),
      lastname: new FormControl('',[
        Validators.required,
        Validators.pattern("[A-Za-z .'-]+"),
        Validators.minLength(2)
      ]),
      email: new FormControl('',[
        Validators.required,
        Validators.email
      ]),
      password: new FormControl('',[
        Validators.required,
        Validators.minLength(6)
      ]),
      confirmPassword: new FormControl('',[
        Validators.required,
      ])
    }
    this.registerForm = this.fb.group(formControls);
  }

  get firstname() { return this.registerForm.get('firstname') }
  get lastname() { return this.registerForm.get('lastname') }
  get email() { return this.registerForm.get('email') }
  get password() { return this.registerForm.get('password') }
  get confirmPassword() { return this.registerForm.get('confirmPassword') }

  ngOnInit(): void {
  }

  register(user: User) {

    console.log(user);
    this.userService.add(user).toPromise().then((res) => {
      this.router.navigate(['article/all']);
      this.toastr.success('Hallo, ' + user.firstname + '! Sie wurden erfolgreich registriert')
    }).catch(() => {
      this.toastr.error('Die Registrierung wurde nicht erfolgreich abgeschlossen!')
    })

    
  }
}
