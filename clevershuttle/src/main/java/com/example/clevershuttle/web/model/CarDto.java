package com.example.clevershuttle.web.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    static final long serialVersionUID = -5815566940065181210L;

    @Null
    private Long id;

    @NotNull
    private String brand;

    @NotBlank
    private String licensePlate;

    @NotNull
    private String manufacturer;

    @NotNull
    private Long operationCity;

    @NotNull
    private Status status;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdAt;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastUpdatedAt;
}
