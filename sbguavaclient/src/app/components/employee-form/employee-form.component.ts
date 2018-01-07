import {Component, OnInit} from '@angular/core';
import {Employee} from '../../employee';
import {Router} from '@angular/router';
import {EmployeeService} from '../../shared-service/employee.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})

export class EmployeeFormComponent implements OnInit {

  private employee = new Employee();

  constructor(private _employeeService: EmployeeService, private _router: Router) {}

  ngOnInit() {
    this.employee = this._employeeService.getter();
  }

  back() {
    this._router.navigate(['/']);
  }

  createEmployee() {
    this._employeeService.createEmployee(this.employee).subscribe((employee) => {
      console.log(employee);
      this._router.navigate(['/']);
    }, (error) => {
      console.log(error);
    });
  }

  updateEmployee() {
    this._employeeService.updateEmployee(this.employee).subscribe((employee) => {
      console.log(employee);
      this._router.navigate(['/']);
    }, (error) => {
      console.log(error);
    });
  }


//  processForm() {
//    this.createEmployee();
//    this.updateEmployee();
//  }

}

