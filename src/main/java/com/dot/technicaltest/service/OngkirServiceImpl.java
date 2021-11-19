package com.dot.technicaltest.service;

import com.dot.technicaltest.dto.OngkirRequestDto;
import com.dot.technicaltest.exception.BadRequestException;
import com.dot.technicaltest.exception.DataNotFoundException;
import com.dot.technicaltest.repository.CityRepository;
import com.dot.technicaltest.utility.JsonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OngkirServiceImpl implements OngkirService {
    private final String key = "e263c9c2adda9f486921519117fd6be8";
    private final String url = "https://api.rajaongkir.com/starter/cost";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CityRepository repository;

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("key", key);
        headers.set("content-type", "application/x-www-form-urlencoded");
        return headers;
    }

    @SneakyThrows
    @Override
    @Cacheable(cacheNames = "cekOngkir", key = "T(java.util.Objects).hash(#request.getWeight(),#request.getCourier()" +
            ",#request.getOrigin(),#request.getDestination())")
    public Object cekOngkir(OngkirRequestDto request) {
        var origin = repository.findByCityName(request.getOrigin());
        var dest = repository.findByCityName(request.getDestination());

        if (origin.isEmpty() || dest.isEmpty())
            throw new DataNotFoundException();

        var body = "origin=" + origin.get().getCityId() + "&destination=" + dest.get().getCityId() + "&weight=" +
                request.getWeight() + "&courier=" + request.getCourier();

        var entity = new HttpEntity(body, getHeaders());
        try {
            var resp = restTemplate.postForEntity(url, entity, String.class);
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> result = null;
            try {
                result = mapper.readValue(resp.getBody(), HashMap.class);
            } catch (JsonProcessingException e) {
                log.error("failed to parse data", e.getMessage());
            }

            return result;
        } catch (HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString());
            String message = JsonUtility.parseOngkirResponse(e.getResponseBodyAsString());
            throw new BadRequestException(message);
        }

    }
}
