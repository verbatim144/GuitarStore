import { TestBed } from '@angular/core/testing';

import { GuitarsService } from './guitars.service';

describe('GuitarsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GuitarsService = TestBed.get(GuitarsService);
    expect(service).toBeTruthy();
  });
});
