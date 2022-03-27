package com.migros.couriertracking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.migros.couriertracking.constants.Constant.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CourierTrackingRuleException.class)
    public final ResponseEntity<Object> handleAllExceptions() {

        var formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy HH:MM:SS"));
        var response = ExceptionResponse.builder().dateTime(formattedDateTime)
                .message(COURIER_EXCEPTION_RULE_EXCEPTION).build();

        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
    }


    @ExceptionHandler(StoreCreateException.class)
    public final ResponseEntity<Object> handleStoreExceptions() {

        var formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy HH:MM:SS"));
        var response = ExceptionResponse.builder().dateTime(formattedDateTime)
                .message(STORE_CREATE_EXCEPTION).build();

        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
    }

    @ExceptionHandler(CourierRelationException.class)
    public final ResponseEntity<Object> handleCourierRelationAExceptions() {

        var formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy HH:MM:SS"));
        var response = ExceptionResponse.builder().dateTime(formattedDateTime)
                .message(NO_RELATION_COURIER_EXCEPTION).build();

        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
    }
}
