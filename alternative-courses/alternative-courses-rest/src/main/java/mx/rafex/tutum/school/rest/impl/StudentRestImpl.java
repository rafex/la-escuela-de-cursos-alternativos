package mx.rafex.tutum.school.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.rafex.tutum.school.model.rest.EnrollRequestRest;
import mx.rafex.tutum.school.model.rest.ResponseHandler;
import mx.rafex.tutum.school.rest.StudentRest;
import mx.rafex.tutum.school.service.StudentService;

@RestController
public class StudentRestImpl implements StudentRest {

    @Autowired
    private StudentService studentService;

    @Override
    public ResponseEntity<?> list(final String student) {

        final var students = studentService.list(convert(student));

        return ResponseHandler.response(students);
    }

    @Override
    public ResponseEntity<?> enrollSubject(
            final EnrollRequestRest requestRest) {

        LOG.info("Dentro");

        return ResponseHandler.response();
    }

}
