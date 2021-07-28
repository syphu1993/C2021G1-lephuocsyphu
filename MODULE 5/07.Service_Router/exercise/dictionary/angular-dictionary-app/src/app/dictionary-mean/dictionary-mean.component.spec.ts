import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionaryMeanComponent } from './dictionary-mean.component';

describe('DictionaryMeanComponent', () => {
  let component: DictionaryMeanComponent;
  let fixture: ComponentFixture<DictionaryMeanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictionaryMeanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionaryMeanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
