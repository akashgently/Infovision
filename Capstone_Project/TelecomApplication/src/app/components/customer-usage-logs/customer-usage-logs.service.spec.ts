import { TestBed } from '@angular/core/testing';

import { CustomerUsageLogsService } from './customer-usage-logs.service';

describe('CustomerUsageLogsService', () => {
  let service: CustomerUsageLogsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerUsageLogsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
