package co.istad.mongodb.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResponseStatusException.class)
    ResponseEntity<?> handleResponseException(ResponseStatusException e) {
        Map<String, Object> error = new HashMap<>();
        error.put("Status", e.getStatusCode().value());
        error.put("Message", e.getMessage());
        error.put("Time", LocalDateTime.now().toString());

        return ResponseEntity.status(e.getStatusCode()).body(error);
    }

}
