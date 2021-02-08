
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { ServiceRequestComponent } from './service-request/service-request.component';
import { ViewComponent } from './view/view.component';

const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
    { path: 'employees', component: EmployeeListComponent },
    { path: 'add-emp', component: CreateEmployeeComponent },
    { path: 'update-emp/:id', component: EmployeeDetailsComponent },
    { path: 'emp-detail/:id', component: EmployeeDetailComponent },
    { path: 'service-request', component: ServiceRequestComponent },
    { path: 'login', component: ViewComponent }

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
