package com.example.clevershuttle.web.controller;


import com.example.clevershuttle.web.model.CarDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/car")
@RestController
public class CarController {

    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("carId") Long carId) {

        //todo impl
        return new ResponseEntity<>(CarDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewCar(@RequestBody CarDto carDto) {

        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
