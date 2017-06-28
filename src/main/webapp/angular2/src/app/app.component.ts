import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    private baseUrl = 'http://localhost:8080/api/v1/users';
    public submitted: boolean;
    userSubmit: FormGroup;
    users: User[];

    constructor(private http: Http) {
    }
    ngOnInit() {
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
    onSubmit({value, valid}: { value: UserSubmit, valid: boolean }) {
        let bodyString = JSON.stringify(value); // Stringify payload
        let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
        let options = new RequestOptions({headers: headers}); // Create a request option

        this.http.post(this.baseUrl, value, options)
            .subscribe(res => console.log(res));
    }
    getAllUsers(){
        this.getAll().
            subscribe(users => this.users = users,
            error => {
                console.log(error);
            });
    }
    updateUser(value: String) {
        console.log('user Id for update is: ' + value);
    }
    getAll(): Observable<User[]> {
        return this.http
            .get(this.baseUrl)
            .map(this.mapUser);
    }
    mapUser(response: Response): User[] {
        return response.json().content;
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

export interface User {
    userId: String;
    firstName: String;
    middleName: String;
    lastName: String;
    age: number;
    gender: String;
    phoneNumber: String;
    zip: String;
}

