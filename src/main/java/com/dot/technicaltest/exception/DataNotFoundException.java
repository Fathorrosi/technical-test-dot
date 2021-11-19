package com.dot.technicaltest.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}