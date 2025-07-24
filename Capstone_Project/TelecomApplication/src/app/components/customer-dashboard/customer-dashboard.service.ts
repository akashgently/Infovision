import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerDashboardService {

   token = localStorage.getItem("token");
          apiBaseUrl = environment.apiBaseUrl;
        
          constructor(private http: HttpClient) { }
        
          findByPlanId(id:number) {
            const headers = new HttpHeaders({
              'Authorization': this.token ? this.token : ''
            });
            return this.http.get(`${this.apiBaseUrl}/plan/individual/${id}`, { headers });
          }
  
        getCustomerById(id: number) {
            const headers = new HttpHeaders({
              'Authorization': this.token ? this.token : ''
            });
            return this.http.get(`${this.apiBaseUrl}/user/customer/${id}`, { headers });
          }
  
        getBillsByUser(id: number) {
            const headers = new HttpHeaders({
              'Authorization': this.token ? this.token : ''
            });
            return this.http.get(`${this.apiBaseUrl}/billing/user/${id}`, { headers });
          }

          getLogByUserId(id: number) {
          const headers = new HttpHeaders({
            'Authorization': this.token ? this.token : ''
          });
          return this.http.get(`${this.apiBaseUrl}/usage/log/${id}`, { headers });
        }
}
