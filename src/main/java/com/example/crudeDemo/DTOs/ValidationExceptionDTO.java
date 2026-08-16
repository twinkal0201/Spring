package com.example.crudeDemo.DTOs;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionDTO {
    private LocalDateTime timeStamp;
    private int statusCode;
    private String error;
    private String massage;
    private String path;
    private Map<String,String> feildsErrors;

    public ValidationExceptionDTO(LocalDateTime timeStamp, int statusCode, String error, String massage, String path, Map<String, String> feildsErrors) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.error = error;
        this.massage = massage;
        this.path = path;
        this.feildsErrors = feildsErrors;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFeildsErrors() {
        return feildsErrors;
    }

    public void setFeildsErrors(Map<String, String> feildsErrors) {
        this.feildsErrors = feildsErrors;
    }
}
