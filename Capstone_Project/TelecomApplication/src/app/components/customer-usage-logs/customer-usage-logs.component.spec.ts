import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerUsageLogsComponent } from './customer-usage-logs.component';

describe('CustomerUsageLogsComponent', () => {
  let component: CustomerUsageLogsComponent;
  let fixture: ComponentFixture<CustomerUsageLogsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerUsageLogsComponent]
    });
    fixture = TestBed.createComponent(CustomerUsageLogsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
