import { Component, ElementRef, ViewChild } from '@angular/core';
import { CustomerService } from './customer.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ToastService } from '../toast/toast.service';
import { LoginService } from 'src/app/service/loginservice';
import { ConfirmationService } from 'primeng/api';
import { PlanService } from '../plan/plan.service';
import { MatTabChangeEvent, MatTabGroup } from '@angular/material/tabs';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent {
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
  firstname: any;
  lastname: any;
  location: any;
    constructor(
      private service: CustomerService,
      private planservice:PlanService,
      private snackBar: MatSnackBar,
      private toastService: ToastService,
      private confirmationService: ConfirmationService,
      private loginService: LoginService
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
  
    onViewTabSelect(event: MatTabChangeEvent): void {
      if (event.index === 0) {
        this.openTab = false;
      } else if (event.index === 1) {
        if (this.openTab === false) {
          this.resetForm();
        }
      }
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
    
    save() {
  if (this.firstname && this.lastname && this.location && this.email && this.phone && this.plan) {
    this.isValidated = true;

    const customer = {
      firstname: this.firstname,
      lastname: this.lastname,
      location: this.location,
      email: this.email,
      phone: this.phone,
      planId: this.plan
    };

    const user = {
      lastName: this.lastname,
      firstName: this.firstname,
      emailId: this.email,
      mobile: this.phone,
      userType: "user",
      password: "admin" 
    };
    this.loginService.registeruser(user).subscribe(
      (userRes) => {
        this.service.addCustomer(customer).subscribe(
          (customerRes) => {
            this.showSucessToast('Customer added successfully');
            this.getAllCustomers(); 
          },
          (error) => {
            this.showErrorToast('Error adding customer');
            console.error(error);
          }
        );
      },
      (error) => {
        this.showErrorToast('Error registering user');
        console.error(error);
      }
    );

    this.resetForm();
    this.selectedTabIndex = 0;
  } else {
    this.isValidated = false;
    this.showWarningToast('Required fields are missing');
  }
}



    update() {
      if (this.firstname && this.lastname && this.location && this.email && this.phone && this.plan) {  
          const customer = {
              firstname: this.firstname,
              lastname: this.lastname,
              location: this.location,
              email: this.email,
              phone: this.phone,
              planId: this.plan
          };
  
          this.service.updateCustomer(this.id, customer).subscribe(
                  (res: any) => {
          this.showSucessToast('Customer updated successfully');
          this.selectedTabIndex = 0;
          this.getAllCustomers();
        },
        (error) => {
          console.error('Error updating plan', error);
          this.showErrorToast('Error updating plan');
        }
      );
  }else {
      this.isValidated = false;
      this.showWarningToast('Required fields are missing');
    }
  }
  
    delete(element: any) {
      const id = element.id;
      this.confirmationService.confirm({
        message: 'Do you want to delete this customer?',
        icon: 'pi pi-exclamation-triangle',
        header: 'Confirmation',
        rejectButtonStyleClass: 'button-reject',
        accept: () => {
          this.service.deleteCustomer(id).subscribe(
            (res) => {
              this.showSucessToast('Customer deleted successfully');
              this.getAllCustomers();
              this.selectedRow = null;
            },
            (error) => {
              console.error('Error deleting employee', error);
              this.showErrorToast('Error deleting employee');
            }
          );
        },
        reject: () => { },
      });
    }
  
    resetForm() {
      this.firstname = '';
      this.lastname = '';
      this.location = '';
      this.email = '';
      this.phone = '';
      this.plan = '';
    }
  
    EditDetails(element: any) {
      this.selectedRow = element;
      this.openTab = true;
      this.isEdit=true;
      this.tabs.selectedIndex = 1;
      this.id = element.id;
      this.email = element.email;
      this.firstname = element.firstname;
      this.lastname = element.lastname;
      this.location = element.location;
      this.plan = element.planId;
      this.phone = element.phone;
    }
  
  }
  
