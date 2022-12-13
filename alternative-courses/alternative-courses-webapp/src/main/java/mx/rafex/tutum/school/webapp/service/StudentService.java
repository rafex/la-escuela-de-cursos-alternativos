package mx.rafex.tutum.school.webapp.service;

import java.util.List;

import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.model.vo.Subject;

public interface StudentService {

    List<Student> list(Object keyword);

    List<Subject> getSubjects(int idStudent);

    void saveScore(int idStudent, int idSubject, double score);

}
