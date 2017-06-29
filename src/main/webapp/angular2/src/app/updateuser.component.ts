import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { UserComponent } from './user.component'
import { User } from './user'


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./app.component.css']
})
export class UpdateUserComponent implements OnInit {

  private baseUrl = 'http://localhost:8080/api/v1/users';
  public submitted: boolean;
  userSubmit: FormGroup;
  user: User;

  constructor(private http: Http) {
  }
  ngOnInit(): void {
    this.userSubmit = new FormGroup({
      userId: new FormControl(''),
      firstName: new FormControl(''),
      middleName: new FormControl(''),
      lastName: new FormControl(''),
      age: new FormControl(''),
      gender: new FormControl(''),
      phoneNumber: new FormControl(''),
      zip: new FormControl('')
    });
  }
  onSubmit({ value, valid }: { value: UserSubmit, valid: boolean }) {
    const bodyString = JSON.stringify(value); // Stringify payload
    const headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    const options = new RequestOptions({ headers: headers }); // Create a request option

    this.http.post(this.baseUrl, value, options)
      .subscribe(res => console.log(res));

  }

}
export interface UserSubmit {
  userId: String;
  firstName: String;
  middleName: String;
  lastName: String;
  age: number;
  gender: String;
  phoneNumber: String;
  zip: String;
}

