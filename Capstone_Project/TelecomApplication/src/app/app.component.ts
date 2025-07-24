import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { SidebarService } from './service/SidebarService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  logo:string='assets/images/seyasignup/seyalogo.png';
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  isSideBarOpen = true;
  isSideBarEight = true;
  showSidebarAndHeader = true;
  show = true;

  constructor(private router: Router, private sidebarService: SidebarService) {
    this.router.events.subscribe(() => {
      const route = this.router.url;
      if (route === '/' || route === '/login' || route === '/forgot-password' || this.router.url.startsWith('/reset-password')) {
        this.showSidebarAndHeader = false;
        this.show = false;
      } else {
        this.show = true;
        this.showSidebarAndHeader = true;
      }
    });
  }

  toggleButton() {
    this.isSideBarOpen = !this.isSideBarOpen;
    this.isSideBarEight = !this.isSideBarEight;
    this.sidebarService.toggleSidebar();
  }


  closeButton() {
    this.sidebarService.setSidebarOpen(false);
  }

}
