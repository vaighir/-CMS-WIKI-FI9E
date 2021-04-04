import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  username: string = "Mark";
  host: string = "http://localhost/RestAPI/v1";
  route: string = "/hi/";



  constructor(private http: HttpClient) { }

  ngOnInit(): void {

  }

  testAPI() {
    console.log("making request...");
    this.http.get(this.host + this.route + this.username).toPromise()
    .then((data) => {
      alert("Yay" + data + " responded");
      console.log(data);
    })
    .catch((error) => {
      alert("Error" + error + " responded");
      console.error(error);
    });
  }
}
