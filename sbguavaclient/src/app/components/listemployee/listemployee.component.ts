import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../shared-service/employee.service';
import {Employee} from '../../employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-listemployee',
  templateUrl: './listemployee.component.html',
  styleUrls: ['./listemployee.component.css']
})
export class ListemployeeComponent implements OnInit {
  private employees: Employee[];
  constructor(private _employeeService: EmployeeService, private _router: Router) {}

  ngOnInit() {
    this._employeeService.getEmployees().subscribe((employees) => {
      console.log(employees);
      this.employees = employees;
    }, (error) => {
      console.log(error);
    }
    );
  }

  saveEmployee() {
    let employee = new Employee();
    this._employeeService.setter(employee);
    this._router.navigate(['/createorupdate']);
  }

  updateEmployee(employee) {
    this._employeeService.setter(employee);
    this._router.navigate(['/createorupdate']);
  }

  deleteEmployee(employee) {
    this._employeeService.deleteEmployee(employee.id).subscribe((data) => {
      this.employees.splice(this.employees.indexOf(employee), 1);
    }, (error) => {
      console.log(error);
    });

  }

}

