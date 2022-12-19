package mx.rafex.tutum.school.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.rafex.tutum.school.model.rest.ResponseHandler;
import mx.rafex.tutum.school.rest.SubjectRest;
import mx.rafex.tutum.school.service.SubjectService;

@RestController
public class SubjectRestImpl implements SubjectRest {

    @Autowired
    private SubjectService service;

    @Override
    public ResponseEntity<?> list(String subject) {
        return ResponseHandler.response(service.list(convert(subject)));
    }

}
