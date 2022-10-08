package com.example.clevershuttle.web.services;

import com.example.clevershuttle.web.model.CarDto;

public interface CarService {

    CarDto getById(Long carId);

    CarDto saveNewCar(CarDto carDto);
}
