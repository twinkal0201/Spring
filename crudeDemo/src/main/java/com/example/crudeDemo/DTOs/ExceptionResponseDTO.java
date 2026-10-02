package com.example.crudeDemo.DTOs;

import java.time.LocalDateTime;

public class ExceptionResponseDTO {
    private LocalDateTime timeStamp;
    private int statisCode;
    private String error;
    private String massage;
    private String path;

    public ExceptionResponseDTO(LocalDateTime timeStamp, int statisCode, String error, String massage, String path) {
        this.timeStamp = timeStamp;
        this.statisCode = statisCode;
        this.error = error;
        this.massage = massage;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatisCode() {
        return statisCode;
    }

    public void setStatisCode(int statisCode) {
        this.statisCode = statisCode;
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
}
