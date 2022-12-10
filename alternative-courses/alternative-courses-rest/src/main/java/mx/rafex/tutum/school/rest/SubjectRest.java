package mx.rafex.tutum.school.rest;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/v01/subject")
public interface SubjectRest extends Rest {

    Logger LOG = Logger.getLogger(SubjectRest.class.getName());

    @RequestMapping(method = { RequestMethod.GET }, produces = {
            APPLICATION_JSON_UTF8 })
    ResponseEntity<?> list(
            @RequestParam(required = false, name = "materia") String subject);

}
