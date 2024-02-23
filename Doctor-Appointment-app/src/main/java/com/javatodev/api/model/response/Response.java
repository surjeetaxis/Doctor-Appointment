package com.javatodev.api.model.response;

import lombok.Data;

@Data
public class Response {

    private int statusCode;
    private String message;
    private boolean success;
    private Object data;

    // Constructors, getters, and setters
    public Response(int statusCode, String message, boolean success, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    // Getters and setters
    // You can generate these using your IDE or manually write them
}