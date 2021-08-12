import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenieInsertComponent } from './genie-insert.component';

describe('GenieInsertComponent', () => {
  let component: GenieInsertComponent;
  let fixture: ComponentFixture<GenieInsertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenieInsertComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenieInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
