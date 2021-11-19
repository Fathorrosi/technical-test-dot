package com.dot.technicaltest.controller;

import com.dot.technicaltest.entity.City;
import com.dot.technicaltest.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/rajaongkir")
public class CityController {
    private final CityService cityService;

    @GetMapping("/getAll")
    public List<City> getAll() {
        return cityService.getAll();
    }

    @PostMapping("/create")
    public City create(@RequestBody City city) {
        return cityService.create(city);
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        cityService.delete(id);
        return "City with id " + id + " was deleted";
    }

    @GetMapping("/findById")
    public Optional<City> findById(Long id) {
        return cityService.findById(id);
    }

}
