package com.example.clevershuttle.web.controller;


import com.example.clevershuttle.web.mappers.CarMapper;
import com.example.clevershuttle.web.model.CarDto;
import com.example.clevershuttle.web.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/car")
@RestController
public class CarController {

    private final CarService carService;

    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("carId") Long carId) {
        return new ResponseEntity<>(carService.getById(carId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDto> saveNewCar(@RequestBody CarDto carDto) {
        return new ResponseEntity<>(carService.saveNewCar(carDto), HttpStatus.CREATED);
    }
}
