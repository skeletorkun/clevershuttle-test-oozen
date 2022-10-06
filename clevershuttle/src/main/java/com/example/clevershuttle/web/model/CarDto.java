package com.example.clevershuttle.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private Long id;
    private String brand;
    private String licensePlate;
    private String manufacturer;
    private UUID operationCity;
    private Status status;
}
