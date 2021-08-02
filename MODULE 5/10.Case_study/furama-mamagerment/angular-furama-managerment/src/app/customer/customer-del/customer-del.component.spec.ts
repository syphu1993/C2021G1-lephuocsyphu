import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerDelComponent } from './customer-del.component';

describe('CustomerDelComponent', () => {
  let component: CustomerDelComponent;
  let fixture: ComponentFixture<CustomerDelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerDelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerDelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
