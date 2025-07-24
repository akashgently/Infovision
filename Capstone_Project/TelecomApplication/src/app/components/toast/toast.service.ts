import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

export interface Toast {
  message: string;
  type: 'success' | 'error' | 'info' | 'warning';
  duration?: number;
}

@Injectable({
  providedIn: 'root'
})
export class ToastService {
  private toasts: Toast[] = [];
  public toasts$ = new Subject<Toast[]>();

  addToast(toast: Toast) {
    this.toasts.push(toast);
    this.toasts$.next(this.toasts);

    setTimeout(() => this.removeToast(toast), toast.duration || 5000);
  }

  removeToast(toast: Toast) {
    this.toasts = this.toasts.filter(t => t !== toast);
    this.toasts$.next(this.toasts);
  }
}
