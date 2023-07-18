import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CitconsultComponent } from './citconsult.component';

describe('CitconsultComponent', () => {
  let component: CitconsultComponent;
  let fixture: ComponentFixture<CitconsultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CitconsultComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CitconsultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
