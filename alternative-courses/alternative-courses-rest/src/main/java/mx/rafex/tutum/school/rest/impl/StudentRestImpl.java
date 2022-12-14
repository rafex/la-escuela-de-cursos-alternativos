package mx.rafex.tutum.school.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.rafex.tutum.school.model.mapper.SubjectMapper;
import mx.rafex.tutum.school.model.rest.EnrollRequestRest;
import mx.rafex.tutum.school.model.rest.ResponseHandler;
import mx.rafex.tutum.school.model.rest.ScoreRequestRest;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.model.vo.StudentSubjects;
import mx.rafex.tutum.school.model.vo.Subject;
import mx.rafex.tutum.school.rest.StudentRest;
import mx.rafex.tutum.school.service.StudentService;

@RestController
public class StudentRestImpl implements StudentRest {

    private final SubjectMapper SUBJECT_MAPPER = SubjectMapper.INSTANCE;

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
    public ResponseEntity<?> saveScore(final int idStudent,
            final ScoreRequestRest requestRest) {

        var studentSubjects = new StudentSubjects();

        studentSubjects.setStudent(new Student(idStudent));

        if (requestRest.getSubjects() != null
                && !requestRest.getSubjects().isEmpty()) {
            List<Subject> subjects = new ArrayList<>();

            requestRest.getSubjects().forEach(s -> {
                subjects.add(SUBJECT_MAPPER.restToSubject(s));
            });

            studentSubjects.setSubjects(subjects);
        }

        if (studentService.saveScore(studentSubjects)) {
            return ResponseHandler.response();
        }

        return ResponseHandler.response(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
