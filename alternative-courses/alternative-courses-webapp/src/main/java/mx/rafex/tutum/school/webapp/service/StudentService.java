package mx.rafex.tutum.school.webapp.service;

import java.util.List;

import mx.rafex.tutum.school.model.mapper.SubjectMapper;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.model.vo.Subject;

public interface StudentService {

    SubjectMapper SUBJECT_MAPPER = SubjectMapper.INSTANCE;

    List<Student> list(Object keyword);

    List<Subject> getSubjects(int idStudent);

    void saveScore(int idStudent, List<Subject> subjects);

}
