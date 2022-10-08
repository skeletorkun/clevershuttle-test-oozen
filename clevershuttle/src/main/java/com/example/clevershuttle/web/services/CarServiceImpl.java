package com.example.clevershuttle.web.services;

import com.example.clevershuttle.domain.Car;
import com.example.clevershuttle.repository.CarRepository;
import com.example.clevershuttle.web.NotFoundException;
import com.example.clevershuttle.web.mappers.CarMapper;
import com.example.clevershuttle.web.model.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto getById(Long carId) {
        return carMapper.carToCarDto(
                carRepository.findById(carId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public CarDto saveNewCar(CarDto carDto) {
        Car car = carMapper.carDtoToCar(carDto);
        Car savedNewCar = carRepository.save(car);
        return carMapper.carToCarDto(savedNewCar);
    }
}
