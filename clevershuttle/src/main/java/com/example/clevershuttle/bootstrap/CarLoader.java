package com.example.clevershuttle.bootstrap;

import com.example.clevershuttle.domain.Car;
import com.example.clevershuttle.web.model.Status;
import com.example.clevershuttle.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarLoader implements CommandLineRunner {

    private final CarRepository carRepository;

    public CarLoader(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) {
        loadCarObjects();
    }

    private void loadCarObjects() {
        if (carRepository.count() == 0) {

            carRepository.save(Car.builder()
                    .brand("Golf")
                    .licensePlate("L-CS8877E")
                    .manufacturer("Volkswagen")
                    .operationCity(1L)
                    .status(Status.AVAILABLE.toString())
                    .build());

            carRepository.save(Car.builder()
                    .brand("308")
                    .licensePlate("L-CS1122F")
                    .manufacturer("Peugeot")
                    .operationCity(2L)
                    .status(Status.OUT_OF_SERVICE.toString())
                    .build());
        }
    }
}
