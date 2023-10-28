import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminuComponent } from './adminu.component';

describe('AdminuComponent', () => {
  let component: AdminuComponent;
  let fixture: ComponentFixture<AdminuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminuComponent]
    });
    fixture = TestBed.createComponent(AdminuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
