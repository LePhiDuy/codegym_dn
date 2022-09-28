import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { P1NameCardComponent } from './p1-name-card.component';

describe('P1NameCardComponent', () => {
  let component: P1NameCardComponent;
  let fixture: ComponentFixture<P1NameCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ P1NameCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(P1NameCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
