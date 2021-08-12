import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenieComponent } from './genie.component';

describe('GenieComponent', () => {
  let component: GenieComponent;
  let fixture: ComponentFixture<GenieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
