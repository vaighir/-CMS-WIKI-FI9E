import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  username: string = "Mark";

  //use API-paths.ts | Host (static) here instead
  host: string = "http://localhost/RestAPI/v1";
  route: string = "/hi/";



  constructor(private http: HttpClient) { }

  ngOnInit(): void {

  }

  testAPI() {
    console.log("making request...");
    this.http.get(this.host + this.route + this.username).toPromise()
    .then((data) => {
      console.log(data);
    })
    .catch((error) => {
      console.error(error);
    });
  }
}
