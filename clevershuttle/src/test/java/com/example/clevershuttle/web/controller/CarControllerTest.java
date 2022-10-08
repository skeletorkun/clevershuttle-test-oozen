package com.example.clevershuttle.web.controller;

import com.example.clevershuttle.web.model.CarDto;
import com.example.clevershuttle.web.model.Status;
import com.example.clevershuttle.web.services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CarService carService;

    @Test
    void getCarById() throws Exception {

        given(carService.getById(any())).willReturn(getValidCarDto());

        mockMvc.perform(get("/api/car/" + 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brand", is("Carrera")))
                .andExpect(jsonPath("$.licensePlate", is("ABC-983-XYZ")))
                .andExpect(jsonPath("$.manufacturer", is("Porche")))
                .andExpect(jsonPath("$.operationCity", is(2)))
                .andExpect(jsonPath("$.status", is("IN_MAINTENANCE")))
        ;
    }

    @Test
    void saveNewCar() throws Exception {

        CarDto carDto = CarDto.builder().build();
        String carDtoJson = objectMapper.writeValueAsString(carDto);

        given(carService.saveNewCar(any())).willReturn(getValidCarDto());

        mockMvc.perform(post("/api/car/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(carDtoJson))
                .andExpect(status().isCreated())
        ;
    }

    CarDto getValidCarDto() {
        return CarDto.builder()
                .id(5L)
                .brand("Carrera")
                .manufacturer("Porche")
                .licensePlate("ABC-983-XYZ")
                .operationCity(2L)
                .status(Status.IN_MAINTENANCE)
                .build();
    }
}