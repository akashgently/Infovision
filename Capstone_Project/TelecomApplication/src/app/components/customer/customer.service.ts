import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  token = localStorage.getItem("token");
      apiBaseUrl = environment.apiBaseUrl;
    
      constructor(private http: HttpClient) { }
    
      getAllCustomers() {
        const headers = new HttpHeaders({
          'Authorization': this.token ? this.token : ''
        });
        return this.http.get(`${this.apiBaseUrl}/user/all`, { headers });
      }
      getCustomerById(id: number) {
        const headers = new HttpHeaders({
          'Authorization': this.token ? this.token : ''
        });
        return this.http.get(`${this.apiBaseUrl}/user/customer/${id}`, { headers });
      }
      addCustomer(customer: any){
        const headers = new HttpHeaders({
          'Authorization': this.token ? this.token : '',
        });
    
        return this.http.post<any>(`${this.apiBaseUrl}/user/add`, customer, { headers });
      }
      updateCustomer(id: number, customer: any){
        const headers = new HttpHeaders({
          'Authorization': this.token ? this.token : ''
        });
    
        return this.http.put<any>(`${this.apiBaseUrl}/user/update/${id}`, customer, { headers });
    }
    deleteCustomer(id: number){
      const headers = new HttpHeaders({
        'Authorization': this.token ? this.token : '',
      });
    
      return this.http.delete<any>(`${this.apiBaseUrl}/user/delete/${id}`, { headers });
    }
}
