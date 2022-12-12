package mx.rafex.tutum.school.service;

import java.util.List;

import mx.rafex.tutum.school.model.vo.Student;

public interface StudentService {

    List<Student> list(int id);

    boolean enrollSubject(int idStudent, int idSubject);

}
