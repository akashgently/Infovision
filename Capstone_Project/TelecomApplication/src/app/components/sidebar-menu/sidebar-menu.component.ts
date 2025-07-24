import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrls: ['./sidebar-menu.component.css']
})
export class SidebarMenuComponent {
  isSideBarOpen=false;
  isSideBarClose=false;
  showSidebarAndHeader=true;
  roleId = Number(localStorage.getItem("roleId"));
  email: any;
  token: any;
  userId: any;
  loginData: any;
  permissionList: any;
  mainMenu: any;
  subMenu: any;
  mapMenu: any;
  userType: any;
  status!:Boolean;
  static isReportOpen: Boolean = false;
  static isMasterOpen: Boolean = false;
  permission:any

  constructor(private router: Router,private http: HttpClient) {}

  ngOnInit(): void {
    this.token = localStorage.getItem("token")|| '';
    this.userType = localStorage.getItem('userType') || '';
    
  }

  isActiveRoute(route: string): boolean {
    return this.router.url.startsWith(route);
  }

  toggleButton(){
    this.isSideBarOpen=!this.isSideBarOpen;
  }
  closeButton(){
    this.isSideBarClose=!this.isSideBarClose;
  }

  isMenuActive(str:any){
    if(str == "R"){
      if(SidebarMenuComponent.isReportOpen){
        return true
      }else{
        return false
      }
    }else{
      if(SidebarMenuComponent.isMasterOpen){
        return true
      }else{
        return false
      }
    }
  }

}
