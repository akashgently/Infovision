import { Component } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.scss']
})
export class MasterComponent {

  currentComponent: string = 'Plan';

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.updateComponentFromRoute();
  }

  updateCurrentComponent(componentName: string): void {
    this.currentComponent = componentName;
  }

  private updateComponentFromRoute(): void {
    const currentRoute = this.router.url;
    if (currentRoute.includes('/master/plan')) {
      this.currentComponent = 'Plan';
    }
  }
}
