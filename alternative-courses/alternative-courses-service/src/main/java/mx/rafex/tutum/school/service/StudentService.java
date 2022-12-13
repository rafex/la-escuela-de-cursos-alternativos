package mx.rafex.tutum.school.service;

import java.util.List;

import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.model.vo.StudentSubjects;

public interface StudentService {

    List<Student> list(int id);

    boolean enrollSubject(int idStudent, int idSubject);

    StudentSubjects getSubjects(int idStudent);

    boolean saveScore(int idStudent, int idSubject, double score);

}
