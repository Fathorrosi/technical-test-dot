package com.dot.technicaltest.dto;

import com.dot.technicaltest.constant.Kurir;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class OngkirRequestDto {
    private String destination;
    private String origin;
    private String weight;
    private Kurir courier;
}
