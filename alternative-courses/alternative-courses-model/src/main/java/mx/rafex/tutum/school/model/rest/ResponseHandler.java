package mx.rafex.tutum.school.model.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseHandler {

    private final static String APPLICATION_JSON_UTF8 = "application/json; charset=utf-8";
    private final static String CONTENT_TYPE = "Content-type";
    private final static String MESSAGE = "message";
    private final static String STATUS = "status";
    private final static String DATA = "data";
    private final static Map<String, String> HEADERS = new HashMap<>();

    static {
        HEADERS.put(CONTENT_TYPE, APPLICATION_JSON_UTF8);
    }

    private ResponseHandler() {

    }

    public static ResponseEntity<?> response(final Map<String, String> headers,
            final String message, final HttpStatus status,
            final Object responseObject) {

        final var httpHeaders = new HttpHeaders();
        headers.forEach((k, v) -> {
            httpHeaders.add(k, v);
        });

        final Map<String, Object> body = new HashMap<>();
        body.put(MESSAGE, message);
        body.put(STATUS, status.value());
        body.put(DATA, responseObject);

        return new ResponseEntity<>(body, httpHeaders, status);
    }

    public static ResponseEntity<?> response(final String message,
            final HttpStatus status, final Object responseObject) {

        return response(HEADERS, message, status, responseObject);
    }

    public static ResponseEntity<?> response(final HttpStatus status,
            final Object responseObject) {

        return response(HEADERS, null, status, responseObject);
    }

    public static ResponseEntity<?> response(final Object responseObject) {

        return response(HEADERS, null, HttpStatus.OK, responseObject);
    }

    public static ResponseEntity<?> response(final String message,
            final HttpStatus status) {
        return response(message, status, null);
    }

    public static ResponseEntity<?> response(final String message) {
        return response(message, HttpStatus.OK, null);
    }

    public static ResponseEntity<?> response(final HttpStatus httpStatus) {
        return response(null, httpStatus, null);
    }

    public static ResponseEntity<?> response() {
        return response(null, HttpStatus.OK, null);
    }
}
