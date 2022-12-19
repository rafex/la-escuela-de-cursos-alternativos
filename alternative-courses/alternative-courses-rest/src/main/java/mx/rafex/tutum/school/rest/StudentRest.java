package mx.rafex.tutum.school.rest;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.rafex.tutum.school.model.mapper.StudentMapper;
import mx.rafex.tutum.school.model.mapper.SubjectMapper;
import mx.rafex.tutum.school.model.rest.EnrollRequestRest;
import mx.rafex.tutum.school.model.rest.ScoreRequestRest;
import mx.rafex.tutum.school.model.rest.StudentsRequestRest;

@RequestMapping("/v01/student")
public interface StudentRest extends Rest {

    StudentMapper STUDENT_MAPPER = StudentMapper.INSTANCE;
    SubjectMapper SUBJECT_MAPPER = SubjectMapper.INSTANCE;

    Logger LOG = Logger.getLogger(StudentRest.class.getName());

    @RequestMapping(method = { RequestMethod.GET }, produces = {
            APPLICATION_JSON_UTF8 })
    ResponseEntity<?> list(
            @RequestParam(required = false, name = "usuario") String student);

    @RequestMapping(method = { RequestMethod.POST }, path = {
            "/{idStudent}/subject" }, produces = {
                    APPLICATION_JSON_UTF8 }, consumes = {
                            APPLICATION_JSON_UTF8 })
    ResponseEntity<?> enrollSubject(
            @PathVariable(name = "idStudent") int idStudent,
            @RequestBody(required = true) EnrollRequestRest requestRest);

    @RequestMapping(method = { RequestMethod.PUT }, path = {
            "/{idStudent}/subject" }, produces = {
                    APPLICATION_JSON_UTF8 }, consumes = {
                            APPLICATION_JSON_UTF8 })
    ResponseEntity<?> saveScore(@PathVariable(name = "idStudent") int idStudent,
            @RequestBody(required = true) ScoreRequestRest requestRest);

    @RequestMapping(method = { RequestMethod.GET }, path = {
            "/{idStudent}/subject" }, produces = { APPLICATION_JSON_UTF8 })
    ResponseEntity<?> getSubjects(
            @PathVariable(name = "idStudent") int idStudent);

    @RequestMapping(method = { RequestMethod.POST }, produces = {
            APPLICATION_JSON_UTF8 }, consumes = { APPLICATION_JSON_UTF8 })
    ResponseEntity<?> save(
            @RequestBody(required = true) StudentsRequestRest requestRest);

}
