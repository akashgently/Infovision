import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerUsageLogsService {
  token = localStorage.getItem("token");
        apiBaseUrl = environment.apiBaseUrl;
      
        constructor(private http: HttpClient) { }
      
        getAllCustomers() {
          const headers = new HttpHeaders({
            'Authorization': this.token ? this.token : ''
          });
          return this.http.get(`${this.apiBaseUrl}/user/all`, { headers });
        }

      getLogByUserId(id: number) {
          const headers = new HttpHeaders({
            'Authorization': this.token ? this.token : ''
          });
          return this.http.get(`${this.apiBaseUrl}/usage/log/${id}`, { headers });
        }

        getPlanByUserId(id: number) {
          const headers = new HttpHeaders({
            'Authorization': this.token ? this.token : ''
          });
          return this.http.get(`${this.apiBaseUrl}/plan/individual/${id}`, { headers });
        }

      generateBill(id: any){
        const headers = new HttpHeaders({
          'Authorization': this.token ? this.token : '',
        });
    
        return this.http.post<any>(`${this.apiBaseUrl}/billing/generate/${id}`,' ', { headers });
      }
  }
  
