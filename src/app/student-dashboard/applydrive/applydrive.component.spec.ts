import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplydriveComponent } from './applydrive.component';

describe('ApplydriveComponent', () => {
  let component: ApplydriveComponent;
  let fixture: ComponentFixture<ApplydriveComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApplydriveComponent]
    });
    fixture = TestBed.createComponent(ApplydriveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
