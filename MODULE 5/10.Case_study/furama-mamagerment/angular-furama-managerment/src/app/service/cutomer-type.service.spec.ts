import { TestBed } from '@angular/core/testing';

import { CutomerTypeService } from './cutomer-type.service';

describe('CutomerTypeService', () => {
  let service: CutomerTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CutomerTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
