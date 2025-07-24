import { Component, ElementRef, ViewChild } from '@angular/core';
import { BillService } from './bill.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTabGroup } from '@angular/material/tabs';
import { ConfirmationService } from 'primeng/api';
import { PlanService } from '../plan/plan.service';
import { ToastService } from '../toast/toast.service';
import { CustomerService } from '../customer/customer.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.scss']
})
export class BillComponent {
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
    customerlist:any;
    displayModal: boolean = false;
        constructor(
          private service: BillService,
          private planservice:PlanService,
          private snackBar: MatSnackBar,
          private toastService: ToastService,
          private customerService: CustomerService
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
          this.getAllBills();
        }
      
        getAllBills() {
  this.filteredData = [];
  this.service.getAllBills().subscribe((res: any) => {
    this.filteredData = [...res].sort((a: any, b: any) => a.id - b.id);
    
    this.filteredData = this.filteredData.map((bill: any) => {
      const customer = this.customerlist.find((c: any) => c.id === bill.userId);
      const plan = this.planlist.find((p: any) => p.id === bill.planId);

      return {
        ...bill,
        customerName: customer ? (customer.firstname+ " " +customer.lastname) : 'Unknown',
        planName: plan ? plan.name : 'Unknown'
      };
    });

    this.dataSource = this.filteredData;
  });
}

      
        getPlanList() {
          this.planlist = [];
          this.planservice.getPlanDetails().subscribe((res: any) => {
            this.planlist = res;
          });
        }

        getAllCustomers() {
      this.customerlist = [];
      this.customerService.getAllCustomers().subscribe((res: any) => {
        this.customerlist = res;
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
        }
      
      }
