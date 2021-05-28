import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit(registerForm: NgForm) {
    if(registerForm.valid) {
      console.log(registerForm.value);
      this.router.navigate(['article/all']);
    } else {
      alert("Bitte, füllen Sie alle Felder richtig aus");
    }

    

  }
}
