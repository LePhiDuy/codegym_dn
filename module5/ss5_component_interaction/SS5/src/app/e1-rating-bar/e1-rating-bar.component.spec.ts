import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { E1RatingBarComponent } from './e1-rating-bar.component';

describe('E1RatingBarComponent', () => {
  let component: E1RatingBarComponent;
  let fixture: ComponentFixture<E1RatingBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ E1RatingBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(E1RatingBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
