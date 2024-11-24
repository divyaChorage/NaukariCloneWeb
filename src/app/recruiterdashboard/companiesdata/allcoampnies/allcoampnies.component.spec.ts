import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllcoampniesComponent } from './allcoampnies.component';

describe('AllcoampniesComponent', () => {
  let component: AllcoampniesComponent;
  let fixture: ComponentFixture<AllcoampniesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllcoampniesComponent]
    });
    fixture = TestBed.createComponent(AllcoampniesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
