package mx.rafex.tutum.school.rest;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.rafex.tutum.school.model.rest.ResponseHandler;
import mx.rafex.tutum.school.rest.util.IntegerUtils;

public interface Rest extends IntegerUtils {

    Logger LOGGER = Logger.getLogger(Rest.class.getName());

    String APPLICATION_JSON_UTF8 = "application/json; charset=utf-8";
    String CONTENT_TYPE = "Content-type";
    String WORKS = "This works!!! v3";
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd_HH-mm-ss";
    String YYYY_MM_DD = "yyyy-MM-dd";
    DateTimeFormatter DATE_TIME_FORMATTER_YYYY_MM_DD_HH_MM_SS = DateTimeFormatter
            .ofPattern(YYYY_MM_DD_HH_MM_SS);
    DateTimeFormatter DATE_TIME_FORMATTER_YYYY_MM_DD = DateTimeFormatter
            .ofPattern(YYYY_MM_DD);

    @RequestMapping(value = "/hello", method = { RequestMethod.GET,
            RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS,
            RequestMethod.DELETE }, produces = {
                    APPLICATION_JSON_UTF8 }, consumes = { APPLICATION_JSON_UTF8,
                            MediaType.APPLICATION_XML_VALUE,
                            MediaType.ALL_VALUE })
    default ResponseEntity<?> hello(final HttpServletRequest request)
            throws IOException {

        final var method = request.getMethod();
        final var message = "It works by the verb " + method;

        LOGGER.info(message);

        String body = null;
        switch (RequestMethod.valueOf(method)) {
        case GET:
            body = WORKS;
            break;
        case POST:
        case PUT:
            body = request.getReader().lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            break;
        default:
            body = WORKS;

        }

        return ResponseHandler.response(message, HttpStatus.OK, body);
    }

}
