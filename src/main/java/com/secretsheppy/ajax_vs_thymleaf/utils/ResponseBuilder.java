package com.secretsheppy.ajax_vs_thymleaf.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    public static Map<String, Object> productResponseBuilder(
            Object status, Object message, Object product) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", message);
        response.put("product", product);
        return response;
    }

}
