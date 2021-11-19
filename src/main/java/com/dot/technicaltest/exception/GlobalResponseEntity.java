package com.dot.technicaltest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class GlobalResponseEntity {
    private Date timestamp;
    private String statusCode;
    private String statusDescription;
    private Object data;

    public static ResponseEntity<GlobalResponseEntity> error(String statusCode, String description, String data, HttpStatus httpStatus) {
        return new ResponseEntity(new GlobalResponseEntity(new Date(), statusCode, description, data), httpStatus);
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    public Object getData() {
        return this.data;
    }

    public GlobalResponseEntity(Date timestamp, String statusCode, String statusDescription, Object data) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.data = data;
    }

    public GlobalResponseEntity() {
    }
}

