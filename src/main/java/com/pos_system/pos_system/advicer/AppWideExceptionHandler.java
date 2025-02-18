package com.pos_system.pos_system.advicer;

import com.pos_system.pos_system.exception.DuplicateEntryException;
import com.pos_system.pos_system.exception.NotFoundException;
import com.pos_system.pos_system.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(
                new StandardResponse(e.getMessage(),404,null),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<StandardResponse> handleDuplicateEntryException(DuplicateEntryException e) {
        return new ResponseEntity<>(
                new StandardResponse(e.getMessage(),409,null),
                HttpStatus.CONFLICT);
    }
}
