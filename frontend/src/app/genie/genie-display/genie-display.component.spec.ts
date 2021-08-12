import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenieDisplayComponent } from './genie-display.component';

describe('GenieDisplayComponent', () => {
  let component: GenieDisplayComponent;
  let fixture: ComponentFixture<GenieDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenieDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenieDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
