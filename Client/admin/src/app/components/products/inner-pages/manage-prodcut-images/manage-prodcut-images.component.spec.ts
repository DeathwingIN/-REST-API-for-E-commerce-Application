import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageProdcutImagesComponent } from './manage-prodcut-images.component';

describe('ManageProdcutImagesComponent', () => {
  let component: ManageProdcutImagesComponent;
  let fixture: ComponentFixture<ManageProdcutImagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ManageProdcutImagesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManageProdcutImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
