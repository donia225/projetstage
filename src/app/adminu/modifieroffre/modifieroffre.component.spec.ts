import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifieroffreComponent } from './modifieroffre.component';

describe('ModifieroffreComponent', () => {
  let component: ModifieroffreComponent;
  let fixture: ComponentFixture<ModifieroffreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifieroffreComponent]
    });
    fixture = TestBed.createComponent(ModifieroffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
