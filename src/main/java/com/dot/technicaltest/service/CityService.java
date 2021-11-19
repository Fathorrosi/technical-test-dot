package com.dot.technicaltest.service;

import com.dot.technicaltest.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    public List<City> getAll();
    public Optional<City> findById(Long id);
    public void delete(Long id);
    public City create(City city);
}
