import { Component, ViewChild } from '@angular/core';
import { PlanService } from './plan.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTabGroup, MatTabChangeEvent } from '@angular/material/tabs';
import { Router } from '@angular/router';
import { ConfirmationService } from 'primeng/api';
import { ToastService } from '../toast/toast.service';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.scss']
})
export class PlanComponent {
   @ViewChild('tabs', { static: false }) tabs!: MatTabGroup;
    filteredData:any[] = [];
    selectedTabIndex = 0;
    openTab = false;
    isValidated: boolean = false;
    showFilters: boolean = true;
    id:any
    typeList = [
  { typeName: 'Postpaid', typeValue: 'postpaid' },
  { typeName: 'Prepaid', typeValue: 'prepaid' }
];
  dataSource: any;
  planName: any;
  price: any;
  type: any;
  validity: any;
  features: any;
  costPerGB: any;
  costPerMinute: any;
  selectedRow: any;

  
    constructor(private service: PlanService, private snackBar: MatSnackBar, private toastService: ToastService,private router:Router, private confirmationService: ConfirmationService) {}
  
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
        duration: 5000,
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
      this.getPlans();
    }
  
  
    onViewTabSelect(event: MatTabChangeEvent): void {
      if (event.index === 0) {
        this.showFilters = true;
        this.openTab = false;
      } else if (event.index === 1) {
        this.showFilters = false;
        if (this.openTab === false) {
          this.resetForm();
        }
      }
    }
  resetForm() {
    this.planName = '';
    this.price=null;
    this.type='';
    this.validity='';
    this.features='';
    this.costPerGB=null;
    this.costPerMinute=null;
    this.isValidated = true;
  }
    EditDetails(element: any) {
      this.openTab = true;
      this.tabs.selectedIndex = 1;
      this.id = element.id;
      this.planName = element.name;
      this.type = element.type;
      this.price = element.price;
      this.validity = element.validity;
      this.features = element.features;
      this.costPerGB = element.costPerGB;
      this.costPerMinute = element.costPerMinute;
      this.selectedRow = element;
  
    }
  
    getPlans() {
      this.filteredData = [];
      this.service.getPlanDetails().subscribe((res: any) => {
  
        this.filteredData = res
        this.filteredData.sort((a: any, b: any) => {
          return a.id - b.id;
      });
  
        this.dataSource = this.filteredData;
      });
    }
    
    save() {
      if (this.planName && this.type && this.validity && this.features && this.costPerGB && this.costPerMinute && this.price) {
        this.isValidated = true;
          const plan = {
          name: this.planName,
          type: this.type,
          validity : this.validity,
          features: this.features,
          costPerGB :  this.costPerGB,
          costPerMinute : this.costPerMinute,
          price: this.price
        };
  
        this.service.addPlan(plan).subscribe((res: any) => {
  
          this.filteredData.push(res);
          this.showSucessToast('Plan  Added Successfully');
          this.getPlans();
          this.resetForm();
         this.selectedTabIndex = 0;
        });
  
      } else {
        this.isValidated = false;
        this.showWarningToast('Required Field are Missing');
      }
    }
  
    update() {
      if (this.planName && this.type && this.validity && this.features && this.costPerGB && this.costPerMinute && this.price) {
  
          const plan = {
              name: this.planName,
              type: this.type,
              validity: this.validity,
              features: this.features,
              costPerGB: this.costPerGB,
              costPerMinute: this.costPerMinute,
              price: this.price
          };
  
              this.service.updatePlan(this.id, plan).subscribe(
                  (res: any) => {
          this.showSucessToast('Plan updated successfully');
          this.selectedTabIndex = 0;
          this.getPlans();
        },
        (error) => {
          console.error('Error updating plan', error);
          this.showErrorToast('Error updating plan');
        }
      );
  } else {
      this.isValidated = false;
      this.showWarningToast('Required fields are missing');
    }
  }
  
  delete(element:any) {
    const id = element.id;
  
    this.confirmationService.confirm({
      message: 'Do you want to delete this plan?',
      icon: 'pi pi-exclamation-triangle',
      header: 'Confirmation',
      rejectButtonStyleClass: 'button-reject',
      accept: () => {
        this.service.deletePlan(id).subscribe(
              (res) => {
                this.showSucessToast('Plan deleted successfully');
                this.getPlans();
                this.selectedRow = null;
              },
              (error) => {
                this.showErrorToast('Error deleting Plan');
              }
        );
      },
      reject: () => {},
    });
  
  }
  
    openSnackBar(message: string, action: string) {
      this.snackBar.open(message, action, {
        duration: 2000,
      });
    }
    
  
  }
  
