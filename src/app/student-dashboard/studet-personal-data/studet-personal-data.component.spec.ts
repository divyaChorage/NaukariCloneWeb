import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudetPersonalDataComponent } from './studet-personal-data.component';

describe('StudetPersonalDataComponent', () => {
  let component: StudetPersonalDataComponent;
  let fixture: ComponentFixture<StudetPersonalDataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StudetPersonalDataComponent]
    });
    fixture = TestBed.createComponent(StudetPersonalDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
