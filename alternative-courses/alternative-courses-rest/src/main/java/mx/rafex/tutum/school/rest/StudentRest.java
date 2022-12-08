package mx.rafex.tutum.school.rest;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface StudentRest {

    Logger LOG = Logger.getLogger(StudentRest.class.getName());

    @RequestMapping(method = { RequestMethod.GET })
    ResponseEntity<?> list(
            @RequestParam(required = true, name = "startDate") String startDate);

}
