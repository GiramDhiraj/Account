package com.easybytes.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResposneDto {

    public ErrorResposneDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

    private String apiPath;
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;

}
