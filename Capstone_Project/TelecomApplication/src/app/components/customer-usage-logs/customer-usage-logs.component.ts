import { Component, ElementRef, ViewChild } from '@angular/core';
import { CustomerUsageLogsService } from './customer-usage-logs.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTabGroup } from '@angular/material/tabs';
import { PlanService } from '../plan/plan.service';
import { ToastService } from '../toast/toast.service';

@Component({
  selector: 'app-customer-usage-logs',
  templateUrl: './customer-usage-logs.component.html',
  styleUrls: ['./customer-usage-logs.component.scss']
})
export class CustomerUsageLogsComponent {
   @ViewChild('tabs', { static: false }) tabs!: MatTabGroup;
      @ViewChild('imgInput') fileInput!: ElementRef;
      dataSource: any[] = [];
      selectedTabIndex = 1;
      openTab = false;
      loading = true;
      public isValidated = true;
    filteredData: any;
    planlist: any;
    public isEdit = false;
    name: any;
    email: any;
    phone: any;
    plan: any;
    selectedRow: any;
    id: any;
  usageloglist: any;
  displayModal: boolean = false;
  type:any
      constructor(
        private service: CustomerUsageLogsService,
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
        this.selectedTabIndex = 0;
        this.openTab = false;
        this.getAllCustomers();
        this.getPlanList();
      }
    
      getAllCustomers() {
        this.filteredData = [];
        this.service.getAllCustomers().subscribe((res: any) => {
          this.filteredData = res;
          this.filteredData = this.filteredData
            .sort((a: any, b: any) => a.id - b.id)
          this.dataSource = this.filteredData;
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
      
    
      resetForm() {
        this.name = '';
        this.email = '';
        this.phone = '';
        this.plan = '';
      }

      onRowSelect(event: any) {
    const selectedElement = event.data;
    this.EditDetails(selectedElement);
  }

      EditDetails(element: any) {
        this.openTab = true;
        this.isEdit=true;
        this.id = element.id;
        this.email = element.email;
        this.name = element.name;
        this.plan = element.planId;
        this.phone = element.phone;
        this.service.getLogByUserId(this.id).subscribe((res: any) => {
      this.usageloglist = res;
      this.usageloglist = this.usageloglist.sort((a: any, b: any) => a.id - b.id);
    });
    this.service.getPlanByUserId(this.id).subscribe((res: any) => {
      this.type = res.type
    });

    this.displayModal = true;
      }

      generatebill(element:any){
        this.service.generateBill(element.id).subscribe((res:any) =>{
          this.displayModal = false;
        });
      }
    
    }