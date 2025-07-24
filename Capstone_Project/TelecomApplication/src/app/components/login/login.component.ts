import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/loginservice';
import Swal from 'sweetalert2';
import { ToastService } from '../toast/toast.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  loginForm!: FormGroup;
  public emailId!: FormControl;
  public password!: FormControl;
  token: string = '';
  PASSWORD_REGEX =
    /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{8,20}$/;
  EMAIL_REGEX = '^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$';
  userType:string='';
  apiBaseUrl = environment.apiBaseUrl;
  filteredlist:any;

  constructor(
    private service: LoginService,
    private router: Router,
    private toast: ToastService,
    private http: HttpClient
  ) {}

  isPasswordVisible: boolean = false;

  togglePasswordVisibility() {
    this.isPasswordVisible = !this.isPasswordVisible;
  }

  ngOnInit(): void {
    this.createFormControls();
    this.createForm();
  }

  createFormControls() {
    (this.emailId = new FormControl('', [
      Validators.required,
      Validators.pattern(this.EMAIL_REGEX),
    ])),
      (this.password = new FormControl('', [Validators.required]));
  }

  createForm() {
    this.loginForm = new FormGroup({
      emailId: this.emailId,
      password: this.password,
    });
  }

  setFocus(inputName: string) {
    const input = document.querySelector(
      `input[name="${inputName}"]`
    ) as HTMLInputElement;
    const label = document.querySelector(
      `label[for="${inputName}"]`
    ) as HTMLLabelElement;

    if (input && label) {
      input.focus();
      label.classList.add('active');
    }
  }

  removeFocus(inputName: string) {
    const input = document.querySelector(
      `input[name="${inputName}"]`
    ) as HTMLInputElement;
    const label = document.querySelector(
      `label[for="${inputName}"]`
    ) as HTMLLabelElement;

    if (input && label) {
      if (input.value.trim() === '') {
        label.classList.remove('active');
      } else {
        label.classList.add('active');
      }
    }
  }

  loginUser () {
    console.warn(this.loginForm.value);
    this.service
      .generateToken({
        emailId: this.loginForm.value.emailId,
        password: this.loginForm.value.password,
      })
      .subscribe(
        (response: string) => {
          const responseObject = JSON.parse(response);
  
          this.token = `Bearer ${responseObject.token}`;
          localStorage.setItem('token', this.token);
  
          this.userType = `${responseObject.userType}`;
          localStorage.setItem('userType', this.userType);

          this.getCustomers().then(() =>{
            this.redirectUser ();
          });
        },
        (error: any) => {
          this.showWarningToast("Invalid Credentials");
        }
      );
  }

  
  redirectUser () {
    if (this.userType === 'admin') {
      Swal.fire({
        icon: 'success',
        title: 'Login Successful',
        text: 'Welcome back!',
        showConfirmButton: false,
        timer: 1000,
      });
      this.router.navigate(['/customer']);
    } else if (this.userType === 'user') {
      const emailId = this.loginForm.value.emailId;
      const customer = this.filteredlist.find((emp: any) => emp.email === emailId);
      localStorage.setItem('id', customer.id);
  
      Swal.fire({
        icon: 'success',
        title: 'Login Successful',
        text: 'Welcome back!',
        showConfirmButton: false,
        timer: 1000,
      });
      this.router.navigate(['/dashboard']);
    }
  }

  getCustomers():Promise<void>{
    return new Promise((resolve, reject) => {
      const headers = new HttpHeaders({
        'Authorization': this.token
      });
      this.http.get(`${this.apiBaseUrl}/user/all`, { headers }).subscribe((res:any) =>
      {
        this.filteredlist = res;
        resolve();
      });
    });
  }
  
  showWarningToast(message: string) {
    this.toast.addToast({
      message: message,
      type: 'warning',
      duration: 3000,
    });
  }
}
