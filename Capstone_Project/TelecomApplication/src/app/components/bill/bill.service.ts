import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BillService {
  token = localStorage.getItem("token");
          apiBaseUrl = environment.apiBaseUrl;
        
          constructor(private http: HttpClient) { }
        
          getAllBills() {
            const headers = new HttpHeaders({
              'Authorization': this.token ? this.token : ''
            });
            return this.http.get(`${this.apiBaseUrl}/billing/all`, { headers });
          }
  
    }
    
