package com.example.clevershuttle.repository;

import com.example.clevershuttle.domain.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
}
