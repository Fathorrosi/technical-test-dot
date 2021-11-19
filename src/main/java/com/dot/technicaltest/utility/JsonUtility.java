package com.dot.technicaltest.utility;

import com.dot.technicaltest.dto.OngkirResponseDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtility {

    public static String parseOngkirResponse(String str) throws JSONException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        OngkirResponseDto.ContainerResp resp = mapper.readValue(str, OngkirResponseDto.ContainerResp.class);
        return resp.getRajaOngkir().getStatus().getDescription();
    }
}
