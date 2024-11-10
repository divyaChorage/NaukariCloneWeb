import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompaniesdataComponent } from './companiesdata.component';

describe('CompaniesdataComponent', () => {
  let component: CompaniesdataComponent;
  let fixture: ComponentFixture<CompaniesdataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CompaniesdataComponent]
    });
    fixture = TestBed.createComponent(CompaniesdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
