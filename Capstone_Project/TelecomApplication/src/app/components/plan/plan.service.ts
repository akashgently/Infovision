import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlanService {
  token = localStorage.getItem("token");
    apiBaseUrl = environment.apiBaseUrl;
  
    constructor(private http: HttpClient) { }
  
    getPlanDetails() {
      const headers = new HttpHeaders({
        'Authorization': this.token ? this.token : ''
      });
      return this.http.get(`${this.apiBaseUrl}/plan/all`, { headers });
    }
    getPlanById(id: number) {
      const headers = new HttpHeaders({
        'Authorization': this.token ? this.token : ''
      });
      return this.http.get(`${this.apiBaseUrl}/plan/individual/${id}`, { headers });
    }
    addPlan(plan: any){
      const headers = new HttpHeaders({
        'Authorization': this.token ? this.token : '',
      });
  
      return this.http.post<any>(`${this.apiBaseUrl}/plan/add`, plan, { headers });
    }
    updatePlan(planId: number, plan: any){
      const headers = new HttpHeaders({
        'Authorization': this.token ? this.token : ''
      });
  
      return this.http.put<any>(`${this.apiBaseUrl}/plan/update/${planId}`, plan, { headers });
  }
  deletePlan(planId: number){
    const headers = new HttpHeaders({
      'Authorization': this.token ? this.token : '',
    });
  
    return this.http.delete<any>(`${this.apiBaseUrl}/plan/delete/${planId}`, { headers });
  }
}
