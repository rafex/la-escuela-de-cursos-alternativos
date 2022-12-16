package mx.rafex.tutum.school.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/v01/report")
public interface ReportRest extends Rest {

    @RequestMapping(method = { RequestMethod.GET }, path = { "/{idStudent}" })
    ResponseEntity<?> list(@PathVariable(name = "idStudent") int idStudent);

}
