import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenieDeleteComponent } from './genie-delete.component';

describe('GenieDeleteComponent', () => {
  let component: GenieDeleteComponent;
  let fixture: ComponentFixture<GenieDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenieDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenieDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
