import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SidebarService {
  // Use BehaviorSubject to store the current state of the sidebar
  private sidebarOpenSubject = new BehaviorSubject<boolean>(false);

  // Expose the observable for the sidebar's open state
  sidebarOpen$ = this.sidebarOpenSubject.asObservable();

  // Method to toggle the sidebar's state
  toggleSidebar() {
    const currentState = this.sidebarOpenSubject.value;
    this.sidebarOpenSubject.next(!currentState);
  }

  // Method to set sidebar state directly (open or close)
  setSidebarOpen(isOpen: boolean) {
    this.sidebarOpenSubject.next(isOpen);
  }
}
