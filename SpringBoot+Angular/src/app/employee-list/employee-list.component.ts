import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  constructor(private employeeService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute) { }

  employeeList: Employee[] | undefined;

  ngOnInit(): void {
    this.getEmployeeList();
  }

  private getEmployeeList() {
    this.employeeService.getEmployees().subscribe(data => {
      this.employeeList = data;
    });
  }

  dateilEmployee(id: number) {
    this.router.navigate(['detail-employee', id]);
  }

  updateEmployee(id: number) {
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployeeList();
    },
      error => console.log(error));
  }

}
