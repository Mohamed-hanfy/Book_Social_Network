package com.mohamed.book_network.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import static org.springframework.http.HttpStatus.*;

public enum BusinessErrorCodes {
    NO_CODE(0, NOT_IMPLEMENTED,"No code"),

    INCORRECT_CURRENT_PASSWORD(300,BAD_REQUEST,"Current password is incorrect"),

    NEW_PASSWORD_DOES_NOT_MATCH(301,BAD_REQUEST,"The new password is incorrect"),

    ACCOUNT_LOCKED(302,FORBIDDEN,"User account is locked"),

    ACCOUNT_Disabled(303,FORBIDDEN,"User account is disabled"),

    BAD_CREDENTIALS(304,FORBIDDEN,"User name or password is incorrect");

    @Getter
    private int code;
    @Getter
    private String description;
    @Getter
    private HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
