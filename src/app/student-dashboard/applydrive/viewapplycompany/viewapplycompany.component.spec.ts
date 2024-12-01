import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewapplycompanyComponent } from './viewapplycompany.component';

describe('ViewapplycompanyComponent', () => {
  let component: ViewapplycompanyComponent;
  let fixture: ComponentFixture<ViewapplycompanyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewapplycompanyComponent]
    });
    fixture = TestBed.createComponent(ViewapplycompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
