import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { P2ProgressBarComponent } from './p2-progress-bar.component';

describe('P2ProgressBarComponent', () => {
  let component: P2ProgressBarComponent;
  let fixture: ComponentFixture<P2ProgressBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ P2ProgressBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(P2ProgressBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
