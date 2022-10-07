package com.example.clevershuttle.web.controller;

import com.example.clevershuttle.web.model.CarDto;
import com.example.clevershuttle.web.services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getCarById() throws Exception {

        mockMvc.perform(get("/api/car/" + 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void saveNewCar() throws Exception {

        CarDto carDto = CarDto.builder().build();
        String carDtoJson = objectMapper.writeValueAsString(carDto);

        mockMvc.perform(post("/api/car/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(carDtoJson))
                .andExpect(status().isCreated());
    }
}