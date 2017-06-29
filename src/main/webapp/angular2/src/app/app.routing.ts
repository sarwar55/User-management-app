import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
import { UserComponent } from './user.component';
import { UpdateUserComponent } from './updateuser.component';

const appRoutes: Routes = [
  {
    path: '',
    component: UserComponent
  },
   {
    path: 'update',
    component: UpdateUserComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
