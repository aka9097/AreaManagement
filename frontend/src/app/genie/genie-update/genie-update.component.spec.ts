import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenieUpdateComponent } from './genie-update.component';

describe('GenieUpdateComponent', () => {
  let component: GenieUpdateComponent;
  let fixture: ComponentFixture<GenieUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenieUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenieUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
