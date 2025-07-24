import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { authGuard } from './auth.guard';
import { LoginComponent } from './components/login/login.component';
import { MasterComponent } from './components/master/master.component';
import { PlanComponent } from './components/plan/plan.component';
import { CustomerComponent } from './components/customer/customer.component';
import { CustomerUsageLogsComponent } from './components/customer-usage-logs/customer-usage-logs.component';
import { BillComponent } from './components/bill/bill.component';
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: 'customer', component: CustomerComponent,
    data: { role: ['admin'], title: 'Employee' }
  },
  {
    path: 'master',
    component: MasterComponent,
    data: { role: ['admin'], title: 'Master' },
    children: [
      { path: 'plan', component: PlanComponent, data: { role: ['admin'], title: 'Plan' } },
      { path: '', redirectTo: 'plan', pathMatch: 'full' }
    ]
  },
  {
    path: 'customer-usage-logs', component: CustomerUsageLogsComponent,
    data: { role: ['admin'], title: 'Customer Usage Logs' }
  },
  {
    path: 'bill', component: BillComponent,
    data: { role: ['admin'], title: 'Bill' }
  },
  {
    path: 'dashboard', component: CustomerDashboardComponent,
    data: { role: ['user'], title: 'Customer Dashboard' }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
