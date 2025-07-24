
import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { LoginService } from 'src/app/service/loginservice';
import { SidebarService } from 'src/app/service/SidebarService';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';
declare var $:any;
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  providers: [DatePipe]
})

export class HeaderComponent implements OnInit{

  currentdatetime!:Date;
  formattedDate!:any
  dropdownVisible: boolean = false;
  users:any;
  userType:any;
  showModal: boolean = false;
  isSidebarOpen: boolean = false;
  employeedetail: any;
  username: string = ''; 
  empOrgId: any;
  email: any;
  token: any;
  tenantId: any;
  // employeeBaseUrl = environment.employeeBaseUrl;
  // baseurl = environment.reportbaseUrl;
  @Input() show!: any;
  emailId : any;
  employeeId:any;
 userDetails:any;
 companyName: any;
 profileUrl: any;
 clientId:any;

 isNewPasswordVisible: boolean = false;
 isConfirmPasswordVisible: boolean = false;
 
 newPassword: string = '';
 confirmPassword: string = '';

 isPasswordStrong: boolean = false;
 isValidated: boolean = false;
 passwordMismatch: boolean = false;

  constructor(private sidebarService: SidebarService, private service: LoginService, private router: Router,private http: HttpClient){}
  ngOnInit(): void {
    this.userType = localStorage.getItem('userType') || '';
    this.token = localStorage.getItem("token") || '';
    this.tenantId = localStorage.getItem("tenantId") || '';
    this.employeeId = Number(localStorage.getItem("employeeId"));
    this.emailId = localStorage.getItem("emailId");
    this.clientId = localStorage.getItem("clientId");
    this.currentdatetime=new Date();    
    this.sidebarService.sidebarOpen$.subscribe((isOpen: boolean) => {
      this.isSidebarOpen = isOpen;
    }); 

    
    // if (this.show && this.employeeId) {
    //   this.findByEmployeeId(this.employeeId).subscribe((data) => {
    //     this.username = data.username;
    //     this.empOrgId = data.empOrgId;
    //     this.email = data.email;
    //     this.profileUrl = data.profileUrl;                
    //     this.employeedetail = data.employeedetail;
    //   });
    // } 
}


getInitial(firstName: string | undefined | null): string {
  return firstName ? firstName.charAt(0).toUpperCase() : '';
}

onLogoClick(): void {
  if (this.userType === 'admin') {
    this.router.navigate(['/dashboard']);
  } else {
    this.router.navigate(['/employeedashboard']);
  }
}

toggleDropdown() {
  this.dropdownVisible = !this.dropdownVisible;
}

logout() {
Swal.fire({
  title: "Log Out Confirmation",
  text: "Are you sure you want to log out?",
  icon: "warning",
  showCancelButton: true,
  confirmButtonColor: "#3085d6",
  cancelButtonColor: "#d33",
  confirmButtonText: "Log Out!"
}).then((result) => {
  if (result.isConfirmed) {
    // Swal.fire({
    //   title: "Logged Out!",
    //   text: "Successfully Logged Out",
    //   icon: "success",
    //   timer: 2000,
    // });
    this.performLogout();
  }
});
}

private performLogout(): void {
  this.service.removeToken();
  this.router.navigate(['/login']).then(() => {
    // window.location.reload();
  });
}
isSlideoutVisible: boolean = false;
isChangePasswordModalVisible:boolean=false;
toggleSlideout(): void {
  // this.getUserDetails();

  this.isSlideoutVisible = !this.isSlideoutVisible;
}
close(){
  this.isSlideoutVisible = !this.isSlideoutVisible;
}


// findByEmployeeId(employeeId: number) {
//   const headers = new HttpHeaders({
//     'Authorization': this.token,
//     'X-Tenant-ID': this.tenantId
//   });

//   return this.http.get(`${this.employeeBaseUrl}/employee/action/employeeId/${employeeId}`, { headers })
//     .pipe(
//       map((res: any) => {
//         return {
//           username: `${res.firstName} ${res.lastName}`,
//           empOrgId: res.empOrgId,
//           email: res.email,
//           profileUrl: res.profileUrl,
//           employeedetail: res
//         };
//       })
//     );
// }
change() {
  this.isSlideoutVisible = false; 
  this.isChangePasswordModalVisible = true;
}
cancelChange() {
  this.newPassword = '';
  this.confirmPassword = '';
  this.passwordMismatch = false;
  this.isValidated = false; 
  this.isPasswordStrong = true; 
  this.isChangePasswordModalVisible = false; 
}



onPasswordChange() {
  this.isValidated = true;

  const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  this.isPasswordStrong = passwordRegex.test(this.newPassword);

  this.checkPasswordMatch();
}

onConfirmPasswordChange() {
  this.isValidated = true;
  this.checkPasswordMatch();
}

checkPasswordMatch() {
  this.passwordMismatch = this.newPassword !== this.confirmPassword && this.confirmPassword !== '';
}

togglePasswordVisibility(field: string) {
  if (field === 'newPassword') {
    this.isNewPasswordVisible = !this.isNewPasswordVisible;
  } else if (field === 'confirmPassword') {
    this.isConfirmPasswordVisible = !this.isConfirmPasswordVisible;
  }
}

}
