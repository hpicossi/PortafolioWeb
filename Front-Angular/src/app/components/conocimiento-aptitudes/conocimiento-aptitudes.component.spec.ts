import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConocimientoAptitudesComponent } from './conocimiento-aptitudes.component';

describe('ConocimientoAptitudesComponent', () => {
  let component: ConocimientoAptitudesComponent;
  let fixture: ComponentFixture<ConocimientoAptitudesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConocimientoAptitudesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ConocimientoAptitudesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
