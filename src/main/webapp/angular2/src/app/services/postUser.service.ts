import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class PostUserService {
    constructor( private http: Http) {
        console.log('post service initialized. . .');
    }

}
