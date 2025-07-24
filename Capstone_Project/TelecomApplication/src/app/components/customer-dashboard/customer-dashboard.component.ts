import { Component} from '@angular/core';
import { CustomerDashboardService } from './customer-dashboard.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PlanService } from '../plan/plan.service';
import { ToastService } from '../toast/toast.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.scss']
})
export class CustomerDashboardComponent {
      id = Number(localStorage.getItem('id'));
  filteredData: any;
  fullname: any;
  planlist: any;
  phone: any;
  email: any;
  planname: any;
  validity: any;
  userbills:any;
  type:any
  usageloglist:any
        constructor(
          private service: CustomerDashboardService,
          private planservice:PlanService,
          private snackBar: MatSnackBar,
          private toastService: ToastService
        ) { }
      
        showSucessToast(message: string) {
          this.toastService.addToast({
            message: message,
            type: 'success',
            duration: 5000,
          });
        }
      
        showWarningToast(message: string) {
          this.toastService.addToast({
            message: message,
            type: 'warning',
            duration: 3000,
          });
        }
      
        showErrorToast(message: string) {
          this.toastService.addToast({
            message: message,
            type: 'error',
            duration: 5000,
          });
        }
      
        ngOnInit(): void {
          this.getCustomerById();
          this.getPlanList();
          this.getBillsByUser();
        }
      
        getCustomerById() {
          this.filteredData = [];
          this.service.getCustomerById(this.id).subscribe((res: any) => {
            this.filteredData = res;
            this.fullname =  this.filteredData.firstname + " " +  this.filteredData.lastname;
            this.phone = this.filteredData.phone;
            this.email = this.filteredData.email;
            this.service.findByPlanId(this.filteredData.planId).subscribe((res:any) => {
              this.planname = res.name;
              this.validity = res.validity;
              this.type = res.type;
            });
          });
        }

        getBillsByUser(){
          this.service.getBillsByUser(this.id).subscribe((res:any) =>{
            this.userbills = res;
          });

          this.service.getLogByUserId(this.id).subscribe((res: any) => {
      this.usageloglist = res;
      this.usageloglist = this.usageloglist.sort((a: any, b: any) => a.id - b.id);
    });
        }
      
        getPlanList() {
          this.planlist = [];
          this.planservice.getPlanDetails().subscribe((res: any) => {
            this.planlist = res;
          });
        }
      
        openSnackBar(message: string, action: string) {
          this.snackBar.open(message, action, {
            duration: 2000,
          });
        }
      
      }
