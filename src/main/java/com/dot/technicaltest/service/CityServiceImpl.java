package com.dot.technicaltest.service;

import com.dot.technicaltest.entity.City;
import com.dot.technicaltest.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
         repository.deleteById(id);
    }

    @Override
    public City create(City city) {
        return repository.save(city);
    }
}
