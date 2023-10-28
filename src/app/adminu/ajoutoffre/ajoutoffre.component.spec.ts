import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutoffreComponent } from './ajoutoffre.component';

describe('AjoutoffreComponent', () => {
  let component: AjoutoffreComponent;
  let fixture: ComponentFixture<AjoutoffreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AjoutoffreComponent]
    });
    fixture = TestBed.createComponent(AjoutoffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
