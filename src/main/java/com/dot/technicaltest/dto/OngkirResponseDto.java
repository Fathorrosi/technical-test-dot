package com.dot.technicaltest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OngkirResponseDto {

    @Getter
    @Setter
    public static class Status {
        @JsonProperty("code")
        public String code;

        @JsonProperty("description")
        public String description;
    }

    @Getter
    @Setter
    public static class RajaOngkir {
        @JsonProperty("status")
        public Status status;
    }

    @Getter
    @Setter
    public static class ContainerResp {
        @JsonProperty("rajaongkir")
        public RajaOngkir rajaOngkir;
    }

}
