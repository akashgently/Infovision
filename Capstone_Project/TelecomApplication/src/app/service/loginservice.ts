import { HttpClient, HttpParams, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { LoginRequest } from '../loginRequest';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  token = localStorage.getItem("token");
  apiBaseUrl = environment.apiBaseUrl;
  public tokenKey = 'token';

  constructor(public http: HttpClient) { }
  public generateToken(request:any){
    return this.http.post<string>(`${this.apiBaseUrl}/auth/login`, request, {responseType: 'text' as 'json'});
  }

   public registeruser(request:any){
    return this.http.post<string>(`${this.apiBaseUrl}/auth/signup`, request, {responseType: 'text' as 'json'});
  }

  public getToken() {
    return localStorage.getItem(this.tokenKey);
  }

  public setToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  public removeToken(){
    localStorage.clear();
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    if (!token) {
      return false;
    }
    const decodedToken = JSON.parse(atob(token.split('.')[1]));

    // Check if the token is expired
    const now = Date.now().valueOf() / 1000;
    if (decodedToken.exp < now) {
      this.removeToken();
      return false;
    }
    return true;
  }
}
