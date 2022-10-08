package com.example.clevershuttle.web.mappers;

import com.example.clevershuttle.domain.Car;
import com.example.clevershuttle.web.model.CarDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CarMapper {

    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto dto);
}
