package com.dot.technicaltest.controller;

import com.dot.technicaltest.constant.Kurir;
import com.dot.technicaltest.dto.OngkirRequestDto;
import com.dot.technicaltest.service.OngkirService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/rajaongkir")
public class OngkirController {
    private final OngkirService cekOngkirService;

    @GetMapping("/cekongkir")
    public ResponseEntity<Object> cekOngkir(@RequestParam(name = "kurir") Kurir kurir,
                                            @RequestParam(name = "destination") String destination,
                                            @RequestParam(name = "origin") String origin,
                                            @RequestParam(name = "weight") String weight) {
        OngkirRequestDto cekOngkirRequest = OngkirRequestDto.builder()
                .courier(kurir).destination(destination).origin(origin).weight(weight).build();
        var response = cekOngkirService.cekOngkir(cekOngkirRequest);

        return ResponseEntity.ok(response);
    }
}
