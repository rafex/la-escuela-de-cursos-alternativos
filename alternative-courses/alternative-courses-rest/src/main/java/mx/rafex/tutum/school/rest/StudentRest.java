package mx.rafex.tutum.school.rest;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.rafex.tutum.school.model.rest.EnrollRequestRest;

@RequestMapping("/v01/student")
public interface StudentRest extends Rest {

    Logger LOG = Logger.getLogger(StudentRest.class.getName());

    @RequestMapping(method = { RequestMethod.GET }, produces = {
            APPLICATION_JSON_UTF8 })
    ResponseEntity<?> list(
            @RequestParam(required = false, name = "usuario") String student);

    @RequestMapping(method = { RequestMethod.POST }, path = {
            "/subject" }, produces = { APPLICATION_JSON_UTF8 }, consumes = {
                    APPLICATION_JSON_UTF8 })
    ResponseEntity<?> enrollSubject(
            @RequestBody(required = true) EnrollRequestRest requestRest);

}
