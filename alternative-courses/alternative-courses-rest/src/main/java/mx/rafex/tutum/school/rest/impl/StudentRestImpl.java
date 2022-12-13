package mx.rafex.tutum.school.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.rafex.tutum.school.model.rest.EnrollRequestRest;
import mx.rafex.tutum.school.model.rest.ResponseHandler;
import mx.rafex.tutum.school.model.rest.ScoreRequestRest;
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
    public ResponseEntity<?> enrollSubject(final int idStudent,
            final EnrollRequestRest requestRest) {

        if (studentService.enrollSubject(idStudent,
                requestRest.getIdSubject())) {
            return ResponseHandler.response();
        }

        return ResponseHandler.response(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> getSubjects(final int idStudent) {
        return ResponseHandler.response(studentService.getSubjects(idStudent));
    }

    @Override
    public ResponseEntity<?> saveScore(final int idStudent, final int idSubject,
            final ScoreRequestRest requestRest) {

        if (studentService.saveScore(idStudent, idSubject,
                requestRest.getScore())) {
            return ResponseHandler.response();
        }

        return ResponseHandler.response(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
