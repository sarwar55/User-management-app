import {Component} from '@angular/core';
import {PostUserService} from '../services/postUser.service';

@Component({
    selector: 'user-post',
    template: `<h1> Hi </h1>`,
    providers: [PostUserService]
})
export class UserComponent{ }

