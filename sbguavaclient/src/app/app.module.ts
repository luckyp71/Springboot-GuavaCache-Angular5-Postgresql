import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {HttpModule} from '@angular/http';


import { AppComponent } from './app.component';
import { ListemployeeComponent } from './components/listemployee/listemployee.component';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';

import { EmployeeService } from './shared-service/employee.service';

const appRoutes: Routes = [
  {path: '', component: ListemployeeComponent},
  {path: 'createorupdate', component: EmployeeFormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListemployeeComponent,
    EmployeeFormComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
